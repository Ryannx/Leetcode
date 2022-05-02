package LC_844;

public class LC_844 {
    public boolean backspaceCompare(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        return getHash(s) == getHash(t);
    }

    private int getHash(String s) {

        int base = 31;
        // int M = (int) 1e9 + 7;
        int i = s.length() - 1;
        int count = 0;
        int res = 0;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == '#') {
                count++;
                i--;
            }
            while (i >= 0 && s.charAt(i) != '#' && count != 0) {
                i--;
                count--;
            }
            if (i < 0) {
                return res;
            }
            if (s.charAt(i) == '#') continue;
            res = res * base + s.charAt(i) - '`';
            i--;
        }

        return res;
    }

    public static void main(String[] args) {
        LC_844 lc_844 = new LC_844();
        String s = "aa##a";
        String t = "aaa##a";
        System.out.println(lc_844.backspaceCompare(s, t));
    }
}
