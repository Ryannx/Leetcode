package LC_29;

public class LC_29 {
    public int divide(int dividend, int divisor) {

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long sign = 1;
        if (dividend < 0) {
            sign *= -1;
        }
        if (divisor < 0) {
            sign *= -1;
        }
        long res = 0;
        while (a >= b) {
            long c = b;
            long count = 1;
            while (a >= (c << 1)) {
                c <<= 1;
                count <<= 1;
            }
            a -= c;
            res += count;
        }

        if (res * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res * (int) sign;
    }
}
