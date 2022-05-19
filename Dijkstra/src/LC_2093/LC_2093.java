package LC_2093;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC_2093 {
    public int minimumCost(int n, int[][] highways, int discounts) {

        if (highways == null) {
            return -1;
        }

        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : highways) {
            graph[edge[0]].add(new int[] {edge[1], edge[2]}); // [end, cost]
            graph[edge[1]].add(new int[] {edge[0], edge[2]});
        }

        Comparator<int[]> comparator = (a, b) -> (a[1] - b[1]); // [dst, cost, discount]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator);
        minHeap.add(new int[] {0, 0, discounts});
        boolean[][] visited = new boolean[n][discounts + 1];
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (cur[0] == n - 1) {
                return cur[1];
            }
            if (visited[cur[0]][cur[2]]) continue;
            visited[cur[0]][cur[2]] = true;
            if (graph[cur[0]] == null) continue;
            for (int[] edge : graph[cur[0]]) {
                if (cur[2] > 0) {
                    minHeap.add(new int[] {edge[0], cur[1] + edge[1] / 2, cur[2] - 1});
                }
                minHeap.add(new int[] {edge[0], cur[1] + edge[1], cur[2]});
            }
        }
        return -1;
    }
}
