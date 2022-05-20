package LC_2135;

import java.util.Arrays;
import java.util.HashMap;

public class LC_2135 {
    public int wordCount(String[] startWords, String[] targetWords) {

        if (startWords == null || targetWords == null) {
            return 0;
        }

        // sort
        String[] startSorted = getSortedArray(startWords);
        String[] targetSorted = getSortedArray(targetWords);

        TrieNode root = new TrieNode();
        for (String s : startSorted) {
            root.addWord(s);
        }

        int count = 0;
        for (String t : targetSorted) {
            if (root.isValid(t)) {
                count++;
            }
        }

        return count;
    }

    private String[] getSortedArray(String[] input) {
        String[] res = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            char[] temp = input[i].toCharArray();
            Arrays.sort(temp);
            res[i] = String.valueOf(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        LC_2135 lc_2135 = new LC_2135();
        String[] startWords = {"pieo","v","yz","fsdo","btnlp","qxgy","yhd","uqc","udls","jvhzc"};
        String[] targetWords = {"obrlf","bhczjv","xqygp","osfbd","pnkbtl","iysgo","vz","poiec","fucq"};
        System.out.println(lc_2135.wordCount(startWords, targetWords));
    }
}
