package LC_363;

import java.util.TreeSet;

public class LC_363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {

        if (matrix == null) {
            return 0;
        }
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        if (matrix[0].length == 0) {
            return 0;
        }
        int col = matrix[0].length;

        if (row < col) {
            int[][] newMatrix = new int[col][row];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    newMatrix[j][i] = matrix[i][j];
                }
            }
            return maxSumSubmatrix(newMatrix, k);
        }

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            int[] arr = new int[col];
            for (int j = i; j < row; j++) {
                for (int c = 0; c < col; c++) {
                    arr[c] += matrix[j][c];
                }
                res = Math.max(res, getValidSum(arr, k));
            }
        }

        return res;
    }

    // presum[i] - presum[j] <= k  =>  presum[j] >= presum[i] - k
    private int getValidSum(int[] arr, int k) {

        TreeSet<Integer> set = new TreeSet<>();
        int res = Integer.MIN_VALUE;
        int presum = 0;
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            presum += arr[i];
            if (set.ceiling(presum - k) != null) {
                res = Math.max(res, presum - set.ceiling(presum - k));
            }
            set.add(presum);
        }
        return res;
    }

    public static void main(String[] args) {
        LC_363 lc_363 = new LC_363();
        int[][] matrix = {{2, 2, -1}};
        int k = 0;
        System.out.println(lc_363.maxSumSubmatrix(matrix, k));
    }
}
