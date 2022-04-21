package LC_315.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        int[] temp = new int[end - start + 1];
        int l = start;
        int r = mid + 1;
        int p = 0;
        while (l <= mid && r <= end) {
            if (sortedNums[l] <= sortedNums[r]) {
                temp[p] = sortedNums[l];
                l++;
            } else {
                temp[p] = sortedNums[r];
                r++;
            }
            p++;
        }
        while (l <= mid && p < temp.length) {
            temp[p] = sortedNums[l];
            l++;
            p++;
        }
        while (r <= end && p < temp.length) {
            temp[p] = sortedNums[r];
            r++;
            p++;
        }
        for (int i = start; i <= end; i++) {
            sortedNums[i] = temp[i - start];
        }
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
}
