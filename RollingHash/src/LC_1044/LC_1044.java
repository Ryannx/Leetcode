package LC_1044;

import java.util.HashSet;
import java.util.Objects;

public class LC_1044 {

    private long M;
    private long[] hashTable1;
    private long[] hashTable2;
    private long[] power1;
    private long[] power2;
    private int[] idxLen; // [idx, len]

    private static class Cell {
        private long hashCode1;
        private long hashCode2;
        public Cell(long hashCode1, long hashCode2) {
            this.hashCode1 = hashCode1;
            this.hashCode2 = hashCode2;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Cell) {
                Cell other = (Cell) obj;
                return this.hashCode1 == other.hashCode1 && this.hashCode2 == other.hashCode2;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.hashCode1, this.hashCode2);
        }
    }

    public String longestDupSubstring(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        M = (long) 1<<32;
        int base1 = 31;
        int base2 = 71;
        idxLen = new int[2];
        // preCaculate Hash
        hashTable1 = new long[s.length()];
        hashTable1[0] = s.charAt(0) - 'a';
        for (int i = 1; i < s.length(); i++) {
            hashTable1[i] = hashTable1[i - 1] * base1 % M + s.charAt(i) - 'a';
        }
        hashTable2 = new long[s.length()];
        hashTable2[0] = s.charAt(0) - 'a';
        for (int i = 1; i < s.length(); i++) {
            hashTable2[i] = hashTable2[i - 1] * base2 % M + s.charAt(i) - 'a';
        }

        power1 = new long[s.length() + 1];
        power1[0] = 1;
        for (int i = 1; i < power1.length; i++) {
            power1[i] = power1[i - 1] * base1 % M;
        }
        power2 = new long[s.length() + 1];
        power2[0] = 1;
        for (int i = 1; i < power2.length; i++) {
            power2[i] = power2[i - 1] * base2 % M;
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

        if (idxLen[1] != 0) {
            return s.substring(idxLen[0], idxLen[0] + idxLen[1]);
        }

        return "";
    }

    private boolean isValid(String s, int len) {

        HashSet<Cell> set = new HashSet<>();
        for (int i = 0; i + len - 1 < s.length(); i++) {
            Cell curHashCode = getHash(i, len);
            if (set.contains(curHashCode)) {
                if (len > idxLen[1]) {
                    idxLen[1] = len;
                    idxLen[0] = i;
                }
                return true;
            }
            set.add(curHashCode);
        }

        return false;
    }

    private Cell getHash(int idx, int len) {
        if (idx == 0) {
            return new Cell(hashTable1[len - 1], hashTable2[len - 1]);
        }
        long hashCode1 = (hashTable1[idx + len - 1] - hashTable1[idx - 1] * power1[len] % M + M) % M;
        long hashCode2 = (hashTable2[idx + len - 1] - hashTable2[idx - 1] * power2[len] % M + M) % M;
        return new Cell(hashCode1, hashCode2);
    }

    public static void main(String[] args) {
        LC_1044 lc_1044 = new LC_1044();
        String s = "banana";
        System.out.println(lc_1044.longestDupSubstring(s));
    }
}
