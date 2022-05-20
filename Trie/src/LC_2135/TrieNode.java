package LC_2135;

class TrieNode {
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
            if (cur.nexts[word.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.nexts[word.charAt(i) - 'a'];
        }
        return cur.isWord;
    }
    public boolean isValid(String word) {

        for (int i = 0; i < word.length(); i++) {
            String p1 = word.substring(0, i);
            String p2 = word.substring(i + 1);
            if (this.contains(p1 + p2)) {
                return true;
            }
        }
        return false;
    }
}
