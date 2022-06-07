package LC_1048;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LC_1048 {
    public int longestStrChain(String[] words) {

        if (words == null) {
            return 0;
        }

        Comparator<String> comparator = (a, b) -> (a.length() - b.length());
        Arrays.sort(words, comparator);
        HashMap<String, Integer> str2len = new HashMap<>();
        for (String w : words) {
            str2len.put(w, 1);
        }

        int res = 1;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i) + (word.substring(i + 1));
                Integer len = str2len.get(sub);
                if (len != null) {
                    len++;
                    str2len.put(word, len);
                    res = Math.max(res, len);
                }
            }
        }

        return res;
    }
}
