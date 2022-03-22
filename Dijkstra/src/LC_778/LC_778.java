package LC_778;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_778 {

    private int row;
    private int col;

    public int swimInWater(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;

        // 求最短路径中的最大值
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[row][col];
        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0]);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);
        priorityQueue.add(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;
        int res = Integer.MIN_VALUE;
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            int high = cur[0];
            int r = cur[1];
            int c = cur[2];
            res = Math.max(res, high);
            if (r == row - 1 && c == col - 1) return res;
            for (int d = 0; d < directions.length; d++) {
                int nextR = r + directions[d][0];
                int nextC = c + directions[d][1];
                if (inArea(nextR, nextC) && !visited[nextR][nextC]) {
                    priorityQueue.add(new int[] {grid[nextR][nextC], nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }

        throw new IllegalArgumentException();
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
