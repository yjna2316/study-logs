package effectivejava.chatp03.item15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

  @Test
  void publicFieldModification() {
    // 잘못된 구현 - public 필드 접근
    BadLibrary badLibrary = new BadLibrary();

    // 외부에서 books 필드를 직접 수정 가능
    badLibrary.books.add("New Book");
    assertTrue(badLibrary.books.contains("New Book")); // 외부에서 직접 접근하여 수정
  }

  @Test
  void encapsulatedFieldModification() {
    // 개선된 구현 - private 필드와 getter 사용
    Library goodLibrary = new Library();

    // books 필드는 private이므로 외부에서 직접 접근 불가
    // goodLibrary.books.add("New Book");

    goodLibrary.addBook("New Book");
    assertTrue(goodLibrary.getBooks().contains("New Book"));
  }
}
