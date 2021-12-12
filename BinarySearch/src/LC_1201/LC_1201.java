package LC_1201;

public class LC_1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {

        long start = 1;
        long end = Integer.MAX_VALUE;
//        long aa = a;
//        long bb = b;
//        long cc = c;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (count(mid, a, b, c) < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) start;
    }

    private long count(long mid, long a, long b, long c) {
        return mid / a + mid / b + mid / c - mid / lcm(a, b)
                - mid / lcm(a, c) - mid / lcm(b, c) + mid / lcm(lcm(a, b), c);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        LC_1201 lc_1201 = new LC_1201();
        System.out.println(lc_1201.nthUglyNumber(5, 2, 3, 2));
    }
}
