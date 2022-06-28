package LC_1647;

import java.util.*;

public class LC_1647 {
    public int minDeletions(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        Comparator<Integer> comparator = (a, b) -> (b - a);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);
        for (int c : count) {
            if (c == 0) continue;
            maxHeap.add(c);
        }

        int res = 0;
        while (maxHeap.size() > 1) {
            int cur = maxHeap.poll();
            if (cur == maxHeap.peek()) {
                if (cur - 1 > 0) {
                    maxHeap.add(cur - 1);
                }
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_1647 lc_1647 = new LC_1647();
        String s = "aaabbbcc";
        System.out.println(lc_1647.minDeletions(s));
    }
}
