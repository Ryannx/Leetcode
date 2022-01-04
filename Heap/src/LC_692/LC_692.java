package LC_692;

import java.util.*;

public class LC_692 {
    public List<String> topKFrequent(String[] words, int k) {

        if (words == null || words.length == 0) {
            return null;
        }

        HashMap<String, Integer> word2count = new HashMap<>();
        for (String word : words) {
            int val = word2count.getOrDefault(word, 0);
            word2count.put(word, val + 1);
        }

        Comparator<Map.Entry<String, Integer>> comparator = (a, b) -> (a.getValue() - b.getValue() == 0 ?
                helper(a.getKey(), b.getKey()) : a.getValue() - b.getValue());
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(comparator);
        for (Map.Entry<String, Integer> entry : word2count.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        LinkedList<String> res = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            res.addFirst(minHeap.poll().getKey());
        }

        return res;
    }

    // 相等数值，我们保留字母序小的在heap中
    private int helper(String a, String b) {

        int i = 0;
        while (i < a.length() && i < b.length()) {
            char aCh = a.charAt(i);
            char bCh = b.charAt(i);
            if (aCh < bCh) {
                return 1;
            } else if (aCh > bCh) {
                return -1;
            }
            i++;
        }

        if (a.length() < b.length()) {
            return 1;
        }
        if (a.length() > b.length()) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        LC_692 lc_692 = new LC_692();
        List<String> temp = Arrays.asList("z","love","leetcode","z","love","coding", "zz", "zz");
        String[] words = new String[temp.size()];
        for (int i = 0; i < words.length; i++) {
            words[i] = temp.get(i);
        }
        System.out.println(lc_692.topKFrequent(words, 2));
    }
}
