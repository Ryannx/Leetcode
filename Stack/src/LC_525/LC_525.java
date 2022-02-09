package LC_525;

import java.util.HashMap;

public class LC_525 {
    public int findMaxLength(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> count2idx = new HashMap<>();
        count2idx.put(0, -1);
        int len = nums.length;
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            sum += (nums[i] == 1 ? 1 : -1);
            Integer curIdx = count2idx.get(sum);
            if (curIdx == null) {
                count2idx.put(sum, i);
            } else {
                maxLen = Math.max(maxLen, i - curIdx);
            }
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
