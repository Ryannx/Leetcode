package LC_2290;

import java.util.*;

public class LC_2290 {
    private int m, n;
    public int minimumObstacles(int[][] grid) {

        if (grid == null) {
            return 0;
        }

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        // [idx, removeCount]
        Comparator<int[]> comparator = (a, b) -> (a[1] - b[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator);
        minHeap.add(new int[] {0, 0});
        this.m = grid.length;
        this.n = grid[0].length;
        int[][] minDis = new int[m][n];
        for (int[] r : minDis) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        minDis[0][0] = 0;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int curX = cur[0] / n;
            int curY = cur[0] % n;
            if (curX == m - 1 && curY == n - 1) {
                return cur[1];
            }
            minDis[curX][curY] = cur[1];
            for (int d = 0; d < directions.length; d++) {
                int nextX = curX + directions[d][0];
                int nextY = curY + directions[d][1];
                int next = nextX * n + nextY;
                if (!inArea(nextX, nextY) || grid[nextX][nextY] + cur[1] >= minDis[nextX][nextY]) continue;
                minHeap.add(new int[] {next, cur[1] + grid[nextX][nextY]});
                minDis[nextX][nextY] = cur[1] + grid[nextX][nextY];
            }
        }

        return -1;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
