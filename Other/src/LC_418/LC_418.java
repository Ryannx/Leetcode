package LC_418;

public class LC_418 {

    private int row;
    private int col;
    public boolean removeOnes(int[][] grid) {

        if (grid == null) {
            return true;
        }

        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row - 1; i++) {
            if (isEqual(grid, i, i + 1) || isReverse(grid, i, i + 1)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isEqual(int[][] grid, int curIdx, int nextIdx) {
        for (int i = 0; i < col; i++) {
            if (grid[curIdx][i] != grid[nextIdx][i]) {
                return false;
            }
        }

        return true;
    }

    private boolean isReverse(int[][] grid, int curIdx, int nextIdx) {
        for (int i = 0; i < col; i++) {
            if (grid[curIdx][i] == grid[nextIdx][i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LC_418 lc_418 = new LC_418();
        int[][] grid = {{0,1,0},{1,0,1},{0,1,0}};
        System.out.println(lc_418.removeOnes(grid));
    }
}
