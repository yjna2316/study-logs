package effectivejava.chatp02.item01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {

    // 생성자 사용
    @Test
    public void testConstructorCelsius() {
        Temperature temp = new Celsius(25.0); // 직접 Celsius 생성
        assertTrue(temp instanceof Celsius);
        assertEquals(25.0, temp.getValue());
    }

    @Test
    public void testConstructorFahrenheit() {
        Temperature temp = new Fahrenheit(77.0); // 직접 Fahrenheit 생성
        assertTrue(temp instanceof Fahrenheit);
        assertEquals(77.0, temp.getValue());
    }

    // 정적 팩터리 메서드 사용
    @Test
    public void testFactoryCelsius() {
        Temperature temp = TemperatureFactory.createTemperature("Celsius", 25.0);
        assertTrue(temp instanceof Celsius);
        assertEquals(25.0, temp.getValue());
    }

    @Test
    public void testFactoryFahrenheit() {
        Temperature temp = TemperatureFactory.createTemperature("Fahrenheit", 77.0);
        assertTrue(temp instanceof Fahrenheit);
        assertEquals(77.0, temp.getValue());
    }

    @Test
    public void testFactoryInvalidScale() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TemperatureFactory.createTemperature("Kelvin", 300.0);
        });
        assertEquals("Unknown temperature scale: Kelvin", exception.getMessage());
    }
}
