package LC_527;

import java.util.*;

public class LC_527 {
    public List<String> wordsAbbreviation(List<String> words) {

        if (words == null || words.size() == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<Integer>> abbr2idx = new HashMap<>();
        int n = words.size();
        String[] temp = new String[n];
        for (int i = 0; i < n; i++) {
            String cur = words.get(i);
            if (cur.length() <= 3) {
                temp[i] = cur;
                continue;
            }
            String abbr = getAbbr(cur, 0);
            List<Integer> list = abbr2idx.getOrDefault(abbr, new ArrayList<>());
            list.add(i);
            abbr2idx.put(abbr, list);
        }

        for (Map.Entry<String, List<Integer>> entry : abbr2idx.entrySet()) {
            if (entry.getValue().size() == 1) {
                temp[entry.getValue().get(0)] = entry.getKey();
                continue;
            }
            TrieNode root = new TrieNode();
            for (int idx : entry.getValue()) {
                root.addWord(root, words.get(idx), idx);
            }

            Queue<TrieNode> queue = new LinkedList<>();
            queue.add(root);
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    TrieNode cur = queue.poll();
                    for (TrieNode next : cur.nexts) {
                        if (next == null) continue;
                        if (next.count == 1) {
                            String abbr = getAbbr(words.get(next.idx), step + 1);
                            temp[next.idx] = abbr;
                            continue;
                        }
                        queue.add(next);
                    }
                }
                step++;
            }
        }
        return Arrays.asList(temp);
    }

    private String getAbbr(String word, int end) {

        StringBuilder sb = new StringBuilder();
        int n = word.length();
        if (end == 0) {
            sb.append(word.charAt(0)).append(n - 2).append(word.charAt(n - 1));
            return sb.toString();
        }

        if (n - end <= 2) {
            return word;
        }

        sb.append(word.substring(0, end)).append(n - end - 1).append(word.charAt(n - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        LC_527 lc_527 = new LC_527();
        List<String> words = Arrays.asList("like","god","internal","me","internet","interval","intension","face","intrusion");
        System.out.println(lc_527.wordsAbbreviation(words));
    }
}
