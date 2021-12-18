package LC_139.v2;

import java.util.*;

public class P12172021 {

    private static class TrieNode {
        private TrieNode[] next;
        private boolean isWord;

        public TrieNode() {
            this.next = new TrieNode[26];
        }

        public void addWord(String word) {

            int len = word.length();
            TrieNode curNode = this;
            for (int i = 0; i < len; i++) {
                char cur = word.charAt(i);
                if (curNode.next[cur - 'a'] == null) {
                    curNode.next[cur - 'a'] = new TrieNode();
                }
                curNode = curNode.next[cur - 'a'];
            }
            curNode.isWord = true;
        }

        public boolean isValidWord(String word) {

            int len = word.length();
            TrieNode curNode = this;
            for (int i = 0; i < len; i++) {
                char cur = word.charAt(i);
                if (curNode.next[cur - 'a'] == null) {
                    return false;
                }
                curNode = curNode.next[cur - 'a'];
            }
            return curNode.isWord;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null) {
            return true;
        }

        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            root.addWord(word);
        }

        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, root, 0, memo);
    }

    private boolean dfs(String s, TrieNode root, int idx, Boolean[] memo) {

        int len = s.length();
        if (idx == len) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int i = idx; i < len; i++) {
            String cur = s.substring(idx, i + 1);
            if (root.isValidWord(cur) && dfs(s, root, i + 1, memo)) {
                memo[idx] = true;
                return true;
            }
        }

        memo[idx] = false;
        return false;
    }

    public static void main(String[] args) {
        P12172021 p = new P12172021();
        String s = "aaaaa";
        List<String> wordDict = Arrays.asList("aaa", "aa");
        System.out.println(p.wordBreak(s, wordDict));
    }
}
