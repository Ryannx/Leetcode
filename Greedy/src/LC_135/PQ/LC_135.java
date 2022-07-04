package LC_135.PQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_135 {
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator);
        for (int i = 0; i < n; i++) {
            minHeap.add(new int[] {ratings[i], i});
        }
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (cur[1] - 1 >= 0 && ratings[cur[1] - 1] > ratings[cur[1]] &&
            temp[cur[1] - 1] <= temp[cur[1]]) {
                temp[cur[1] - 1] = temp[cur[1]] + 1;
            }
            if (cur[1] + 1 < n && ratings[cur[1] + 1] > ratings[cur[1]] &&
            temp[cur[1] + 1] <= temp[cur[1]]) {
                temp[cur[1] + 1] = temp[cur[1]] + 1;
            }
        }
        return Arrays.stream(temp).sum();
    }
}
