package LC_695;

public class LC_695 {

    private int row;
    private int col;
    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int[] area = new int[1];
                    dfs(grid, i, j, visited, area);
                    res = Math.max(res, area[0]);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int[] area) {

        if (!inArea(i, j) || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        area[0] += 1;
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited, area);
        dfs(grid, i, j - 1, visited, area);
        dfs(grid, i + 1, j, visited, area);
        dfs(grid, i , j + 1, visited, area);
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
