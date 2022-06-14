package LC_2306;

import java.util.HashSet;

public class LC_2306 {
    public long distinctNames(String[] ideas) {

        if (ideas == null) {
            return 0;
        }

        HashSet<String>[] first2substr = new HashSet[26];
        for (String word : ideas) {
            if (first2substr[word.charAt(0) - 'a'] == null) {
                first2substr[word.charAt(0) - 'a'] = new HashSet<>();
            }
            first2substr[word.charAt(0) - 'a'].add(word.length() == 1 ? "" : word.substring(1));
        }

        long count = 0;
        for (int i = 0; i < first2substr.length; i++) {
            if (first2substr[i] == null) continue;
            for (int j = i + 1; j < first2substr.length; j++) {
                if (first2substr[j] == null) continue;
                long temp1 = first2substr[i].size();
                long temp2 = first2substr[j].size();
                for (String word : first2substr[j]) {
                    if (first2substr[i].contains(word)) {
                        temp1--;
                        temp2--;
                    }
                }
                count += temp1 * temp2;
            }
        }

        return count * 2;
    }

    public static void main(String[] args) {
        LC_2306 lc_2306 = new LC_2306();
        String[] ideas = {"coffee","donuts","time","toffee"};
        System.out.println(lc_2306.distinctNames(ideas));
    }
}
