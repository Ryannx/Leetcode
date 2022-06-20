package LC_527;

public class TrieNode {
    TrieNode[] nexts;
    int count;
    int idx;
    public TrieNode() {
        this.nexts =  new TrieNode[26];
        this.count = 0;
    }

    public void addWord(TrieNode node, String word, int idx) {

        TrieNode cur = node;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char achar = word.charAt(i);
            if (cur.nexts[achar - 'a'] == null) {
                cur.nexts[achar - 'a'] = new TrieNode();
            }
            cur.count++;
            if (cur.count == 1) {
                cur.idx = idx;
            }
            cur = cur.nexts[achar - 'a'];
        }
    }
}
