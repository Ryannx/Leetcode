package LC_410;

public class LC_410 {
    public int splitArray(int[] nums, int m) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, m, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean isValid(int[] nums, int m, int target) {

        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > target) return false;
            int j = i;
            int sum = 0;
            while (j < len && sum + nums[j] <= target) {
                sum += nums[j];
                j++;
            }
            i = j - 1;
            count++;
        }

        return count <= m;
    }
}
