package LC_384;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    private int[] origin;
    private Random random;

    public Solution(int[] nums) {
        origin = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    public int[] reset() {

        return origin;
    }

    public int[] shuffle() {

        int last = origin.length;
        int[] res = Arrays.copyOf(origin, last);
        while (last - 1 >= 0) {
            int idx = random.nextInt(last);
            swap(res, idx, last - 1);
            last--;
        }

        return res;
    }

    private void swap(int[] res, int i, int j) {

        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }
}
