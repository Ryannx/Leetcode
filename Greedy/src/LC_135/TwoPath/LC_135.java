package LC_135.TwoPath;

import java.util.Arrays;

public class LC_135 {
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                temp[i] = Math.max(temp[i], temp[i - 1] + 1);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                temp[i] = Math.max(temp[i], temp[i + 1] + 1);
            }
        }

        return Arrays.stream(temp).sum();
    }
}
