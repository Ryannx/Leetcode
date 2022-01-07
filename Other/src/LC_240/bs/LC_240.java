package LC_240.bs;

import java.util.Arrays;

public class LC_240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return true;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] firstCol = new int[row];
        for (int i = 0; i < row; i++) {
            firstCol[i] = matrix[i][0];
        }

        int rowIdx = Arrays.binarySearch(firstCol, target);
        if (rowIdx >= 0) {
            return true;
        }
        for (int i = 0; i < -rowIdx - 1; i++) {
            if (Arrays.binarySearch(matrix[i], target) >= 0) {
                return true;
            }
        }

        return false;
    }
}
