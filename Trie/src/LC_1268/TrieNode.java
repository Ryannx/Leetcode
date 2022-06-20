package LC_1268;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    private TrieNode[] nexts;
    private List<Integer> idxList;
    private String[] products;

    public TrieNode() {
        this.nexts = new TrieNode[26];
        this.idxList = new ArrayList<>();
    }

    public void initial(String[] products) {
        this.products = products;
    }

    public void addWord(String word, int idx) {
        TrieNode cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.nexts[word.charAt(i) - 'a'] == null) {
                cur.nexts[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.nexts[word.charAt(i) - 'a'];
            cur.idxList.add(idx);
        }
    }

    public List<List<String>> search(String word) {
        List<List<String>> res = new ArrayList<>();
        TrieNode cur = this;
        for (int i = 0; i < word.length(); i++) {
            List<String> list = new ArrayList<>();
            if (cur.nexts[word.charAt(i) - 'a'] == null) {
                res.add(list);
                for (int j = 0; j < word.length() - i -1; j++) {
                    res.add(new ArrayList<>());
                }
                break;
            }
            cur = cur.nexts[word.charAt(i) - 'a'];
            for (int j = 0; j < Math.min(cur.idxList.size(), 3); j++) {
                list.add(products[cur.idxList.get(j)]);
            }
            res.add(list);
        }

        return res;
    }
}
