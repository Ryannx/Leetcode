package LC_820;

import java.util.Arrays;
import java.util.Comparator;

public class LC_820 {

    private static class TrieNode {
        private TrieNode[] nexts;

        public TrieNode() {
            this.nexts = new TrieNode[26];
        }
    }
    public int minimumLengthEncoding(String[] words) {

        if (words == null) {
            return 0;
        }

        String[] temp = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            temp[i] = sb.toString();
        }
        Comparator<String> comparator = (a, b) -> (b.length() - a.length());
        Arrays.sort(temp, comparator);
        TrieNode root = new TrieNode();
        int res = 0;
        for (String word : temp) {
            TrieNode cur = root;
            boolean flag = false;
            for (int i = 0; i <word.length(); i++) {
                char achar = word.charAt(i);
                if (cur.nexts[achar - 'a'] == null) {
                    cur.nexts[achar - 'a'] = new TrieNode();
                    flag = true;
                }
                cur = cur.nexts[achar - 'a'];
            }
            if (flag) {
                res += word.length() + 1;
            }
        }

        return res;
    }
}
