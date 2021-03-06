package TrieNode;

public class TrieNode {
    private TrieNode[] nexts;
    private boolean isWord;

    public TrieNode() {
        this.nexts = new TrieNode[26];
    }

    public void addWord(String word) {
        TrieNode cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.nexts[word.charAt(i) - 'a'] == null) {
                cur.nexts[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.nexts[word.charAt(i) - 'a'];
        }
        cur.isWord = true;
    }

    public boolean contains(String word) {
        TrieNode cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.nexts[word.charAt(i) - 'a'] == null) return false;
            cur = cur.nexts[word.charAt(i) - 'a'];
        }
        return cur.isWord;
    }
}
