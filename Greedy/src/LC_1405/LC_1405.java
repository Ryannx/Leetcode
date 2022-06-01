package LC_1405;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1405 {
    public String longestDiverseString(int a, int b, int c) {

        Comparator<int[]> comparator = (x, y) -> (y[0] - x[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(comparator);
        if (a != 0) {
            maxHeap.add(new int[] {a, 0});
        }
        if (b != 0) {
            maxHeap.add(new int[] {b, 1});
        }
        if (c != 0) {
            maxHeap.add(new int[] {c, 2});
        }

        // [amount, a]
        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) {
                int[] cur = maxHeap.poll();
                int count = Math.min(2, cur[0]);
                for (int i = 0; i < count; i++) {
                    res.append((char) (cur[1] + 'a'));
                }
                return res.toString();
            }
            int[] most = maxHeap.poll();
            int[] second = maxHeap.poll();
            int count = Math.min(1 + most[0] - second[0], 2);
            for (int i = 0; i < count; i++) {
                res.append((char) (most[1] + 'a'));
            }
            res.append((char) (second[1] + 'a'));
            most[0] -= count;
            second[0] -= 1;
            if (most[0] > 0) {
                maxHeap.add(new int[] {most[0], most[1]});
            }
            if (second[0] > 0) {
                maxHeap.add(new int[] {second[0], second[1]});
            }
        }

        return res.toString();
    }
}
