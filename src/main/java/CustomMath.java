import java.util.ArrayList;
import java.util.List;

public class CustomMath {

    // input in radians
    // to translate into degrees : input [rad] = inputDeg / 180 * Math.PI
    public static double cos(double rads) {
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
        return ans;
    }

    public static Double sec (double rads) {
        double cosVal = cos(rads);
//        if (cosVal == 0) return 2.0;
        return 1 / cos(rads);
    }
}