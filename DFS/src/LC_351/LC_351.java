package LC_351;

public class LC_351 {
    private int m, n, res;
    private int[][] directions;
    public int numberOfPatterns(int m, int n) {

        this.m = m;
        this.n = n;
        this.directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1},
                {-1, 2}, {-1, -2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        boolean[][] visited = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                visited[i][j] = true;
                dfs(i, j, visited, 1);
                visited[i][j] = false;
            }
        }
        return res;
    }

    private void dfs(int x, int y, boolean[][] visited, int curStep) {

        if (curStep >= m && curStep <= n) {
            res++;
        }
        if (curStep > n) {
            return;
        }

        for (int d = 0; d < directions.length; d++) {
            int nextX = x + directions[d][0];
            int nextY = y + directions[d][1];
            if (!inArea(nextX, nextY)) continue;
            if (!visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, visited, curStep + 1);
                visited[nextX][nextY] = false;
            } else {
                nextX += directions[d][0];
                nextY += directions[d][1];
                if (!inArea(nextX, nextY) || visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, visited,curStep + 1);
                visited[nextX][nextY] = false;
            }
        }
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < 3 && j >= 0 && j < 3;
    }
}
