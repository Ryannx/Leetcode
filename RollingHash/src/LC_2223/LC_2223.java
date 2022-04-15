package LC_2223;

public class LC_2223 {

    private long M;
    private long[] power;
    private long[] hashTable;

    public long sumScores(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        M = (long) 1e9 + 7;
        // get presum
        power = new long[n + 1];
        power[0] = 1;
        for (int i = 1; i < power.length; i++) {
            power[i] = (26 * power[i - 1]) % M;
        }
        hashTable = new long[n];
        hashTable[0] = s.charAt(0) - 'a';
        for (int i = 1; i < n; i++) {
            hashTable[i] = (s.charAt(i) - 'a' + hashTable[i - 1] * 26) % M;
        }

        // binary search
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != s.charAt(0)) continue;
            int start = 1;
            int end = n - i;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (getHash(i, mid) != hashTable[mid - 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            sum += end;
        }

        return sum;
    }

    private long getHash(int idx, int len) {
        return idx == 0 ? hashTable[idx + len - 1] : (hashTable[idx + len - 1] - (hashTable[idx - 1] * power[len] % M) + M) % M;
    }

    public static void main(String[] args) {
        LC_2223 lc_2223 = new LC_2223();
        String s = "fmfpsvagoyzarkzolszfxuglyygaikqasgcjxnkuenlirdqcpftuxginsrybdgqyiuqwlipnsowfub";
        System.out.println(lc_2223.sumScores(s));
        System.out.println(Long.MAX_VALUE - ((long) 1e9 + 7) * ((long) 1e9 + 7));
        System.out.println(Long.MAX_VALUE);
    }
}
