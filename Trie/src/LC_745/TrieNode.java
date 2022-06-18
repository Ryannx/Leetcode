package LC_745;

class TrieNode {
    private TrieNode[] nexts;
    private int idx;
    
    public TrieNode() {
        this.nexts = new TrieNode[27];
        this.idx = 0;
    }

    public void addWord(TrieNode root, String word, int idx) {
        TrieNode cur = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (cur.nexts[word.charAt(i) - 'a'] == null) {
                cur.nexts[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur.idx = idx;
            cur = cur.nexts[word.charAt(i) - 'a'];
        }
        cur.idx = idx;
    }

    public int contains(TrieNode root, String str) {
        TrieNode cur = root;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (cur.nexts[str.charAt(i) - 'a'] == null) {
                return -1;
            }
            cur = cur.nexts[str.charAt(i) - 'a'];
        }
        return cur.idx;
    }
}
