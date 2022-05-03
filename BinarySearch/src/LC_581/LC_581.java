package LC_581;

public class LC_581 {
    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 1;
        int end = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == 1 && isAscending(nums, 0, nums.length - 1)) {
                return 0;
            }
            if (isValid(nums, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean isValid(int[] nums, int target) {

        int i = 0;
        while (i < nums.length) {
            if (i - 1 >= 0 && !isAscending(nums, 0, i - 1)) {
                i++;
                continue;
            }
            if (i + target < nums.length && !isAscending(nums, i + target, nums.length - 1)) {
                i++;
                continue;
            }
            if (i + target - 1 >= nums.length) {
                i++;
                continue;
            }
            int[] curMinMax = getMinMaxVal(nums, i, i + target - 1);
            if ((i - 1 >= 0 && nums[i - 1] > curMinMax[0])
                    || (i + target < nums.length && nums[i + target] < curMinMax[1])) {
                i++;
                continue;
            }
            return true;
        }
        return false;
    }

    private int[] getMinMaxVal(int[] nums, int start, int end) {

        int[] res = new int[2]; // [min, max]
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            res[0] = Math.min(res[0], nums[i]);
            res[1] = Math.max(res[1], nums[i]);
        }

        return res;
    }

    private boolean isAscending(int[] nums, int start, int end) {
        int i = start;
        while (i <= end) {
            if (i - 1 >= start && nums[i] < nums[i - 1]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        LC_581 lc_581 = new LC_581();
        int[] nums = {1,2,4,5,3};
        System.out.println(lc_581.findUnsortedSubarray(nums));
    }
}
