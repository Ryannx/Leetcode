package LC_745;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    private TrieNode root;
    public WordFilter(String[] words) {
        this.root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            List<String> list = getAllCombiation(words[i]);
            for (String word : list) {
                root.addWord(root, word, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        StringBuilder sb = new StringBuilder();
        sb.append(suffix).append((char) ('z' + 1)).append(prefix);
        return root.contains(root, sb.toString());
    }

    private List<String> getAllCombiation(String word) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder();
            res.add(sb.append(word.substring(i)).append((char) ('z' + 1)).append(word).toString());
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = {"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa"
                ,"abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"};
        WordFilter wordFilter = new WordFilter(words);
        System.out.println(wordFilter.f("bccbacbcba","a"));
    }
}
