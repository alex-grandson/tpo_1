package math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing sec func")
public class CustomMathTest {

    private CustomMath customMath;

    @BeforeEach
    void setup() {
        this.customMath = new CustomMath();
    }


    @ParameterizedTest(name = "Calculate sec({0})")
    @CsvFileSource(resources = "/math/sec_test.csv")
    void secTest(double expected, double inputDeg) {
        final double inputRad = inputDeg / 180 * Math.PI;
        final double actual = customMath.sec(inputRad);
        final double accuracy = 1e-3;
        System.out.printf("expected = %9f | inputDegrees = %2f | actual = %9f\n",
                expected, inputDeg, actual);
        assertEquals(expected, actual, accuracy);
    }

    @ParameterizedTest(name = "Exception sec({0})")
    @ValueSource(doubles = {55555.55, 234234.0129, -1242343.12})
    void secExceptionTest(double value) {
        assertThrows(ArithmeticException.class, () -> {
            customMath.sec(value);
        });
    }


}
