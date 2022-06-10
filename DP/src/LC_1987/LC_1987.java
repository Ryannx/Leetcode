package LC_1987;

public class LC_1987 {
    public int numberOfUniqueGoodSubsequences(String binary) {

        if (binary == null) {
            return 0;
        }

        int n = binary.length();
        String temp = "#" + binary;
        int m = 0;
        for (int i = 0; i <= n; i++) {
            if (temp.charAt(i) == '1') {
                m = i;
                break;
            }
        }

        if (m == 0) {
            return 1;
        }

        long[] dp = new long[n + 1];
        int lastZero = 0;
        int lastOne = 0;
        int base = (int) 1e9 + 7;
        dp[m] = 1;
        for (int i = m + 1; i <= n; i++) {
            int j = temp.charAt(i) == '0' ? lastZero : lastOne;
            dp[i] = (dp[i - 1] * 2 % base - (j - 1 >= 0 ? dp[j - 1] : 0) + base) % base;
            if (temp.charAt(i) == '0') {
                lastZero = i;
            } else {
                lastOne = i;
            }
        }

        return (int) dp[n] + (temp.contains("0") ? 1 : 0);
    }

    public static void main(String[] args) {
        LC_1987 lc_1987 = new LC_1987();
        String binary = "11";
        System.out.println(lc_1987.numberOfUniqueGoodSubsequences(binary));
    }
}
