package LC_1695;

import java.util.*;

public class LC_1695 {
    public int maximumUniqueSubarray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < n && j < n) {
            while (j < n && !set.contains(nums[j])) {
                set.add(nums[j]);
                sum += nums[j];
                j++;
            }
            res = Math.max(res, sum);
            while (i < n && j < n && set.contains(nums[j])) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return res;
    }
}
