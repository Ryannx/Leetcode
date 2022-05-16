package LC_1091;

import java.util.*;

public class LC_1091 {
    private int m, n;
    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid == null || grid[0][0] == 1) {
            return -1;
        }

        this.m = grid.length;
        this.n = grid[0].length;
        if (grid[m - 1][n - 1] == 1) {
            return -1;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int curX = cur / n;
                int curY = cur % n;
                for (int d = 0; d < directions.length; d++) {
                    int nextX = curX + directions[d][0];
                    int nextY = curY + directions[d][1];
                    if (!inArea(nextX, nextY) || visited[nextX][nextY] || grid[nextX][nextY] == 1) continue;
                    if (nextX == m - 1 && nextY == n - 1) {
                        return step + 1;
                    }
                    visited[nextX][nextY] = true;
                    queue.add(nextX * n + nextY);
                }
            }
            step++;
        }

        return -1;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
