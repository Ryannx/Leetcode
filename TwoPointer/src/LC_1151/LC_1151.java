package LC_1151;

import java.util.Arrays;

public class LC_1151 {
    public int minSwaps(int[] data) {

        if (data == null || data.length == 0) {
            return 0;
        }

        int oneAmount = Arrays.stream(data).sum();
        int n = data.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int res = n;
        while (i < n && j < n) {
            count += data[j];
            if (j - i + 1 >= oneAmount) {
                res = Math.min(res, oneAmount - count);
                count -= data[i];
                i++;
            }
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        LC_1151 lc_1151 = new LC_1151();
        int[] data = {1,0,0,1,1,1};
        System.out.println(lc_1151.minSwaps(data));
    }
}
