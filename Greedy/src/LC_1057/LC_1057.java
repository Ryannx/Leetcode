package LC_1057;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {

        if (workers == null || bikes == null) {
            return new int[] {};
        }

        int n = workers.length;
        int m = bikes.length;
        Comparator<int[]> comparator = (a, b) -> (a[0] == b[0] ? (a[1] == b[1] ? (a[2] - b[2]) : a[1] - b[1]) : a[0] -b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator); // [dis, workerIdx, bikeIdx]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dis = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                minHeap.add(new int[] {dis, i, j});
            }
        }

        int[] res = new int[n];
        boolean[] visited = new boolean[m];
        Arrays.fill(res, -1);
        int count = n;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (res[cur[1]] != -1 || visited[cur[2]]) continue;
            res[cur[1]] = cur[2];
            visited[cur[2]] = true;
            count--;
            if (count == 0) {
                return res;
            }
        }

        return res;
    }
}
