package LC_1284;

public class LC_1284 {

    private int m;
    private int n;

    public int minFlips(int[][] mat) {

        m = mat.length;
        n = mat[0].length;
        int res = Integer.MAX_VALUE;

        // 1 represent active flip
        for (int state = 0; state < (1 << (m * n + 1)); state++) {
            if (isValid(state, mat)) {
                res = Math.min(res, countOne(state));
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int countOne(int state) {

        int res = 0;
        while (state != 0) {
            if ((state & 1) == 1) {
                res++;
            }
            state /= 2;
        }

        return res;
    }

    private boolean isValid(int state, int[][] mat) {

        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = mat[i][j];
            }
        }

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {0, 0}};
        for (int s = 0; s < m * n; s++) {
            int lastDigit = state % 2;
            state /= 2;
            if (lastDigit == 0) {
                continue;
            }

            int curI = s / n;
            int curJ = s % n;
            for (int d = 0; d < directions.length; d++) {
                int nextI = curI + directions[d][0];
                int nextJ = curJ + directions[d][1];
                if (!inArea(nextI, nextJ)) {
                    continue;
                }
                temp[nextI][nextJ] = 1 - temp[nextI][nextJ];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        LC_1284 lc_1284 = new LC_1284();
        int[][] mat = {{0, 0}, {0, 1}};
//        System.out.println(Integer.toBinaryString(7));
        System.out.println(lc_1284.minFlips(mat));
    }
}
