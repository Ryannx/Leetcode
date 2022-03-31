package LC_81;

public class LC_81 {
    public boolean search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        if (nums[(len - 1) / 2] == target) {
            return true;
        }
        if (nums[0] == nums[(len - 1) / 2] && nums[0] == nums[len - 1]) {
            for (int num : nums) {
                if (num == target) {
                    return true;
                }
            }
            return false;
        }
        int originStartIdx = getOriginStartIdx(nums);
        if (target == nums[originStartIdx]) {
            return true;
        }

        return exist(nums, 0, originStartIdx - 1, target) || exist(nums, originStartIdx, nums.length - 1, target);
    }

    private int getOriginStartIdx(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    private boolean exist(int[] nums, int start, int end, int target) {

        int s = start;
        int e = end;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC_81 lc_81 = new LC_81();
        int[] nums = {1,3,5};
        System.out.println(lc_81.search(nums, 1));
    }
}
