package LC_540;

public class LC_540 {
    public int singleNonDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid - 1 >= 0 && mid + 1 <= len - 1 && nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1])
                    || start == end) {
                return nums[mid];
            }

            if (mid + 1 < len && nums[mid] == nums[mid + 1]) {
                if ((mid - start) % 2 != 0) {
                    end = mid - 1;
                } else {
                    start = mid + 2;
                }
            } else if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                if ((mid - 1 - start) % 2 != 0) {
                    end = mid - 2;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
