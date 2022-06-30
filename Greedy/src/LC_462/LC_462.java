package LC_462;

import java.util.Arrays;

public class LC_462 {
    public int minMoves2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        long sum = 0;
        for (int num : nums) {
            sum += Math.abs(num - (nums[nums.length / 2]));
        }

        return (int) sum;
    }
}
