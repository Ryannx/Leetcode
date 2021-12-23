package LC_231;

public class LC_231 {
    public boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }
        long x = n;
        return (x & (-x)) == x;
    }

    public static void main(String[] args) {
        String str = Integer.toBinaryString(0);
        System.out.println(str);
    }
}
