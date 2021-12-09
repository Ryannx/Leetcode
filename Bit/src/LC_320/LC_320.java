package LC_320;

import java.util.*;

public class LC_320 {
    public List<String> generateAbbreviations(String word) {

        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            return res;
        }

        for (int mask = 0; mask < (1 << word.length()); mask++) {
            res.add(getAbbr(word, mask));
        }

        return res;
    }

    private String getAbbr(String word, int mask) {

        int len = word.length();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (((mask >> i) & 1) == 1) {
                res.append(word.charAt(i));
            } else {
                int j = i;
                while (j < len && ((mask >> j) & 1) != 1) {
                    j++;
                }
                res.append(j - i);
                i = j - 1;
            }
        }

        return res.toString();
    }
}
