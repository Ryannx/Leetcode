package LC_621.v1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC_621 {
    public int leastInterval(char[] tasks, int n) {

        if (tasks == null) {
            return 0;
        }

        int len = n + 1;
        Comparator<Integer> comparator = (a, b) -> (b - a);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        for (int amount : count) {
            if (amount == 0) continue;
            maxHeap.add(amount);
        }

        int res = 0;

        while (!maxHeap.isEmpty()) {
            int curLen = Math.min(len, maxHeap.size());
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < curLen; i++) {
                int cur = maxHeap.poll();
                cur--;
                if (cur > 0) {
                    temp.add(cur);
                }
            }
            if (temp.size() == 0 && maxHeap.isEmpty()) {
                res += curLen;
                return res;
            }
            res += len;
            for (int num : temp) {
                maxHeap.add(num);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC_621 lc_621 = new LC_621();
        char[] tasks = {'A','B'};
        System.out.println(lc_621.leastInterval(tasks, 0));
    }
}
