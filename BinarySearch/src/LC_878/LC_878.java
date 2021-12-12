package LC_878;

public class LC_878 {

    private int M = (int) 1e9 + 7;
    public int nthMagicalNumber(int n, int a, int b) {

        long start = 1;
        long end = Long.MAX_VALUE;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (count(mid, a, b) < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) (start % M);
    }

    private long count(long mid, long a, long b) {
        return mid / a - mid / lcm(a, b) + mid / b;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        LC_878 lc_878 = new LC_878();
        System.out.println(lc_878.nthMagicalNumber(1000000000, 40000, 40000));
    }
}
