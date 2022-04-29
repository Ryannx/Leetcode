package LC_1631;

import java.util.Comparator;
import java.util.PriorityQueue;
import UF.UnionFind;
public class LC_1631 {

    private int m;
    private int n;
    public int minimumEffortPath(int[][] heights) {

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }

        m = heights.length;
        n = heights[0].length;
        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator);
        int[][] directions = {{-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < directions.length; d++) {
                    int nextX = i + directions[d][0];
                    int nextY = j + directions[d][1];
                    if (!inArea(nextX, nextY)) continue;
                    int distance = Math.abs(heights[i][j] - heights[nextX][nextY]);
                    minHeap.add(new int[] {distance, i * n + j, nextX * n + nextY});
                }
            }
        }

        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m * n; i++) {
            uf.initial(i);
        }
        int target = (m - 1) * n + n - 1;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (!uf.find(cur[1], cur[2])) {
                uf.union(cur[1], cur[2]);
            }
            if (uf.find(0, target)) return cur[0];
        }

        return 0;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
