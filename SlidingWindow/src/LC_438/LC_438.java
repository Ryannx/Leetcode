package LC_438;

import java.util.*;

public class LC_438 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        int pLen = p.length();
        int sLen = s.length();
        int[] letter2amount = countP(p);
        int[] window = new int[26];
        int i = 0;
        int j = 0;
        while (j < pLen) {
            window[s.charAt(j) - 'a']++;
            j++;
        }
        if (isValid(window, letter2amount)) {
            res.add(i);
        }
        while (i < sLen && j < sLen) {
            window[s.charAt(i) - 'a']--;
            i++;
            window[s.charAt(j) - 'a']++;
            j++;
            if (isValid(window, letter2amount)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isValid(int[] window, int[] letter2amount) {

        for (int i = 0; i < window.length; i++) {
            if (window[i] != letter2amount[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] countP(String p) {

        int[] letter2amount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            letter2amount[p.charAt(i) - 'a']++;
        }

        return letter2amount;
    }

    public static void main(String[] args) {
        LC_438 lc_438 = new LC_438();
        String s = "abab";
        String p = "ab";
        System.out.println(lc_438.findAnagrams(s, p));
    }
}
