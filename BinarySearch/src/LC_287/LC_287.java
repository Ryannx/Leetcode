package LC_287;

public class LC_287 {
    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (getLessOrEqual(nums, mid) <= mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    private int getLessOrEqual(int[] nums, int target) {
        int res = 0;
        for (int num : nums) {
            if (num <= target) {
                res++;
            }
        }
        return res;
    }
}
