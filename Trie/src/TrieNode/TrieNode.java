package TrieNode;

public class TrieNode {
    private TrieNode[] nexts;
    private boolean isWord;

    public TrieNode() {
        this.nexts = new TrieNode[26];
    }

    private void addWord(String word) {
        TrieNode cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.nexts[word.charAt(i) - 'a'] == null) {
                cur.nexts[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.nexts[word.charAt(i) - 'a'];
        }
        this.isWord = true;
    }

    private boolean check(String word) {
        TrieNode cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.nexts[word.charAt(i) - 'a'] != null) {
                cur = cur.nexts[word.charAt(i) - 'a'];
                if (i == word.length() - 1 && cur.isWord) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
