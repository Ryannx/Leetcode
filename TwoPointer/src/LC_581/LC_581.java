package LC_581;

public class LC_581 {
    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int  rightBound= 0;
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < curMax) {
                rightBound = i;
            }
            curMax = Math.max(curMax, nums[i]);
        }

        int leftBound = 0;
        int curMin = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > curMin) {
                leftBound = i;
            }
            curMin = Math.min(curMin, nums[i]);
        }

        if (leftBound == rightBound) {
            return 0;
        }
        return rightBound - leftBound + 1;
    }
}
