package math;

import java.util.ArrayList;
import java.util.List;

public class CustomMath {

    // input in radians
    // to translate into degrees : input [rad] = inputDeg / 180 * Math.PI
    private double cos(double rads) throws ArithmeticException {
        double ans = 1;
        double cur = 1;
        double prev = 0;
        final double ACCURACY = 1e-4;

        for (int i = 1; Math.abs(cur - prev) > ACCURACY && i < 1000 ; i++) {
            prev = cur;
            cur *= (-rads * rads);
            cur /= ((2 * i) * (2 * i - 1));
            ans += cur;
        }

        if (ans < -1) return -1;
        if (ans > 1) return 1;
        if (Double.isInfinite(ans) || Double.isNaN(ans)) {
            throw new ArithmeticException("Big value");
        }
        return ans;
    }

    public Double sec(double rads) throws ArithmeticException{
        double resultValue = 0.0;
        try {
            double cosVal = cos(rads);
            resultValue =  1 / cos(rads);
        } catch (ArithmeticException e){
            e.printStackTrace();
        }
        return resultValue;
    }
}
