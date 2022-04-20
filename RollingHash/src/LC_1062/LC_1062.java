package LC_1062;

import java.util.HashSet;

public class LC_1062 {

    private long[] hashTable;
    private long[] power;
    private int base;
    public int longestRepeatingSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        // hash
        this.base = 31;
        this.hashTable = new long[s.length()];
        hashTable[0] = s.charAt(0) - 'a';
        for (int i = 1; i < s.length(); i++) {
            hashTable[i] = hashTable[i - 1] * base + s.charAt(i) - 'a';
        }
        this.power = new long[s.length() + 1];
        power[0] = 1;
        for (int i = 1; i < this.power.length; i++) {
            power[i] = power[i - 1] * base;
        }

        int start = 1;
        int end = s.length() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(s, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (isValid(s, end)) return end;
        return 0;
    }

    private boolean isValid(String s, int len) {

        if (len == 0) return false;
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i + len - 1 < s.length(); i++) {
            long curHashCode = getHash(i, len);
            if (set.contains(curHashCode)) {
                return true;
            }
            set.add(curHashCode);
        }
        return false;
    }

    private long getHash(int i, int len) {
        if (i == 0) {
            if (len == 0) {
                System.out.println();
            }
            return hashTable[i + len - 1];
        }
        return hashTable[i + len - 1] - hashTable[i - 1] * power[len];
    }

    public static void main(String[] args) {
        LC_1062 lc_1062 = new LC_1062();
        String s = "aaaaa";
        System.out.println(lc_1062.longestRepeatingSubstring(s));
    }
}
