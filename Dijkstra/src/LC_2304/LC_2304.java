package LC_2304;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {

        if (grid == null) {
            return 0;
        }

        // [cost, i, j]
        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator);
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            minHeap.add(new int[] {grid[0][i], 0, i});
        }

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (visited[cur[1]][cur[2]]) continue;
            visited[cur[1]][cur[2]] = true;
            if (cur[1] == m - 1) {
                return cur[0];
            }
            for (int j = 0; j < n; j++) {
                int r = grid[cur[1]][cur[2]];
                if (cur[1] + 1 >= m) continue;
                int nextVal = grid[cur[1] + 1][j];
                int[] next = new int[] {cur[0] + nextVal + moveCost[r][j], cur[1] + 1, j};
                minHeap.add(next);
            }
        }

        return -1;
    }
}
