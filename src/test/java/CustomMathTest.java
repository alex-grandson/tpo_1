import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing sec func")
public class CustomMathTest {

    @ParameterizedTest(name = "Calculate sec({0})")
    @CsvFileSource(resources = "/CustomMath/sec_test.csv")
    void secTest(double expected, double inputDeg) {
        double inputRad = inputDeg / 180 * Math.PI;
        double actual = CustomMath.sec(inputRad);
        final double ACCURACY = 1e-3;
        System.out.printf("expected = %9f | inputDegrees = %2f | actual = %9f\n",
                expected, inputDeg, actual);
        assertEquals(expected, actual, ACCURACY);
    }

}
