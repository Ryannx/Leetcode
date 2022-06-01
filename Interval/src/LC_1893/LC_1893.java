package LC_1893;

public class LC_1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {

        int[] diff = new int[100];
        for (int[] r : ranges) {
            diff[r[0]]++;
            diff[r[1] + 1]--;
        }

        int sum = 0;
        for (int i = 1; i <= 50; i++) {
            sum += diff[i];
            if (i >= left && i <= right && sum == 0) {
                return false;
            }
        }

        return true;
    }
}