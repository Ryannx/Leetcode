package LC_240.v2;

public class LC_240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }
}
