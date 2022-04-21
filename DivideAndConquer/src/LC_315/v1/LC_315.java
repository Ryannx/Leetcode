package LC_315.v1;

import java.util.*;

public class LC_315 {
    public List<Integer> countSmaller(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int[] temp = new int[nums.length];
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        helper(nums, sortedNums, temp, 0, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for (int num : temp) {
            res.add(num);
        }
        return res;
    }

    private void helper(int[] nums, int[] sortedNums, int[] res, int start, int end) {

        if (start == end) return;
        int mid = start + (end - start) / 2;
        helper(nums, sortedNums, res, start, mid);
        helper(nums, sortedNums, res, mid + 1, end);
        for (int i = start; i <= mid; i++) {
            int idx = getCeiling(sortedNums, nums[i], mid + 1, end);
            res[i] += idx - 1 - (mid + 1) + 1;
        }

        Arrays.sort(sortedNums, start, end + 1);
    }

    private int getCeiling(int[] sortedNums, int target, int s, int e) {

        int start = s;
        int end = e;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target <= sortedNums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        LC_315 lc_315 = new LC_315();
        int[] nums = {1,1};
        System.out.println(lc_315.countSmaller(nums));
    }
}
