package LC_2321;

import java.util.Arrays;

public class LC_2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {

        return Math.max(Arrays.stream(nums1).sum() + kadane(nums1, nums2),
                Arrays.stream(nums2).sum() + kadane(nums2, nums1));
    }

    private int kadane(int[] nums1, int[] nums2) {
        int dp = 0;
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            dp = Math.max(nums2[i] - nums1[i], nums2[i] - nums1[i] + dp);
            res = Math.max(res, dp);
        }
        return res;
    }
}
