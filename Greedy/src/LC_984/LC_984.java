package LC_984;

import java.util.*;

public class LC_984 {
    public String strWithout3a3b(int a, int b) {

        Comparator<int[]> c = (x, y) -> (y[0] - x[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(c);
        if (a != 0) {
            maxHeap.add(new int[] {a, 'a'});
        }
        if (b != 0) {
            maxHeap.add(new int[] {b, 'b'});
        }

        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() < 2) {
                int[] cur = maxHeap.poll();
                for (int i = 0; i < cur[0]; i++) {
                    res.append((char) cur[1]);
                }
                return res.toString();
            }

            int[] most = maxHeap.poll();
            int[] second = maxHeap.poll();
            int count = Math.min(2, 1 + most[0] - second[0]);
            for (int i = 0; i < count; i++) {
                res.append((char) most[1]);
            }
            res.append((char) second[1]);
            most[0] -= count;
            second[0] -= 1;
            if (most[0] > 0) {
                maxHeap.add(most);
            }
            if (second[0] > 0) {
                maxHeap.add(second);
            }
        }

        return res.toString();
    }
}
