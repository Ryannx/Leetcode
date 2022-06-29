package LC_1851;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1851 {
    public int[] minInterval(int[][] intervals, int[] queries) {

        if (intervals == null || queries == null) {
            return null;
        }

        Comparator<int[]> c1 = (a, b) -> (a[0] - b[0]);
        Arrays.sort(intervals, c1);
        // [query, idx]
        int[][] temp = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            temp[i] = new int[] {queries[i], i};
        }
        Arrays.sort(temp, c1);
        // [duration, right]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(c1);
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] q : temp) {
            while (i < intervals.length && intervals[i][0] <= q[0]) {
                minHeap.add(new int[] {intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q[0]) {
                minHeap.poll();
            }
            if (minHeap.isEmpty()) {
                res[q[1]] = -1;
            } else {
                res[q[1]] = minHeap.peek()[0];
            }
        }

        return res;
    }
}
