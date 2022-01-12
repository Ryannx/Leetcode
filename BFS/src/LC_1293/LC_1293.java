package LC_1293;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1293 {
    public int shortestPath(int[][] grid, int k) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        if (row == 1 && col == 1) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>(); //[i, j, k]
        queue.add(new int[] {0, 0, 0});
        boolean[][][] visited = new boolean[row][col][k + 1];
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int curI = cur[0];
                int curJ = cur[1];
                int curK = cur[2];
                for (int d = 0; d < directions.length; d++) {
                    int nextI = curI + directions[d][0];
                    int nextJ = curJ + directions[d][1];
                    if (nextI == row - 1 && nextJ == col - 1) {
                        return step + 1;
                    }
                    if (!inArea(nextI, nextJ, row, col)) {
                        continue;
                    }
                    if (grid[nextI][nextJ] == 1) {
                        if (curK + 1 <= k && !visited[nextI][nextJ][curK + 1]) {
                            queue.add(new int[] {nextI, nextJ, curK + 1});
                            visited[nextI][nextJ][curK + 1] = true;
                        }
                    } else { // 0
                        if (!visited[nextI][nextJ][curK]) {
                            queue.add(new int[] {nextI, nextJ, curK});
                            visited[nextI][nextJ][curK] = true;
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private boolean inArea(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
