package LC_200;

import java.util.LinkedList;
import java.util.Queue;

public class LC_200 {

    private int row;
    private int col;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {

        Queue<Integer> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        queue.add(i * col + j);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curI = cur / col;
            int curJ = cur % col;
            for (int d = 0; d < directions.length; d++) {
                int nextI = curI + directions[d][0];
                int nextJ = curJ + directions[d][1];
                int next = nextI * col + nextJ;
                if (inArea(nextI, nextJ) && !visited[nextI][nextJ] && grid[nextI][nextJ] == '1') {
                    visited[nextI][nextJ] = true;
                    queue.add(next);
                }
            }
        }
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        LC_200 lc_200 = new LC_200();
        char[][] grid = {{'1'},{'0'},{'1'},{'0'},{'1'},{'1'}};
        System.out.println(lc_200.numIslands(grid));
    }
}
