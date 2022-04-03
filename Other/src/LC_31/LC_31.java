package LC_31;

import java.util.Arrays;

public class LC_31 {
    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int len = nums.length;
        int i = len - 1;
        int j = i - 1;
        // x x x x j i
        while (j >= 0 && j < i) {
            if (nums[j] >= nums[i]) {
                i--;
                j--;
            } else {
                int idx = getCeiling(nums, i, j); // get nums[j] ceiling idx
                swap(nums, idx, j);
                break;
            }
        }

        Arrays.sort(nums, i, len);
    }

    // get nums[j] ceiling idx
    private int getCeiling(int[] nums, int i, int j) {

        int start = i;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[j]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC_31 lc_31 = new LC_31();
        int[] nums = {3,2,1};
        lc_31.nextPermutation(nums);
    }
}
