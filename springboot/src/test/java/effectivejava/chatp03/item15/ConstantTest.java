package effectivejava.chatp03.item15;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MutableConstant {
    public static final int[] VALUES = {1,2,3};
}

class ImmutableConstant {
    private static final Integer[] VALUES_ARRAY = {1, 2, 3};

    // 불변 리스트로 공개하여 외부에서 수정할 수 없도록 함
    public static final List<Integer> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
}

public class ConstantTest {

    @Test
    void mutableConstantModification() {
        // 잘못된 예시 - public static final로 공개된 가변 배열을 외부에서 수정 가능
        int[] values = MutableConstant.VALUES;

        // 배열 요소를 수정할 수 있음
        values[0] = 100;
        assertEquals(100, MutableConstant.VALUES[0]);
    }

    @Test
    void immutableConstantModification() {
        // 개선된 예시 - 불변 리스트로 공개하여 외부에서 수정할 수 없음
        List<Integer> values = ImmutableConstant.VALUES;

        // 리스트에 요소 추가 시도 시 예외 발생
        Exception exception = assertThrows(UnsupportedOperationException.class, () ->
          values.add(100)
        );

      assertNotNull(exception);
      assertEquals(1, ImmutableConstant.VALUES.get(0)); // 원래의 상수 값 유지
    }
}
