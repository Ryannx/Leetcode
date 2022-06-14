package LC_4;

import java.util.Arrays;

public class LC_4 {
    private int m, n;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return 0;
        }

        this.m = nums1.length;
        this.n = nums2.length;
        int start = Math.min(m != 0 ? nums1[0] : Integer.MAX_VALUE, n != 0 ? nums2[0] : Integer.MAX_VALUE);
        int end = Math.max(m - 1 >= 0 ? nums1[m - 1] : Integer.MIN_VALUE, n - 1 >= 0 ? nums2[n - 1] : Integer.MIN_VALUE);
        if ((m + n) % 2 != 0) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (isValidLeftPart(nums1, nums2, mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            return start;
        }
        // even
        int leftPart = 0;
        int rightPart = 0;
        start = Math.min(m != 0 ? nums1[0] : Integer.MAX_VALUE, n != 0 ? nums2[0] : Integer.MAX_VALUE);
        end = Math.max(m - 1 >= 0 ? nums1[m - 1] : Integer.MIN_VALUE, n - 1 >= 0 ? nums2[n - 1] : Integer.MIN_VALUE);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidLeftPart(nums1, nums2, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        leftPart = start;
        start = Math.min(m != 0 ? nums1[0] : Integer.MAX_VALUE, n != 0 ? nums2[0] : Integer.MAX_VALUE);
        end = Math.max(m - 1 >= 0 ? nums1[m - 1] : Integer.MIN_VALUE, n - 1 >= 0 ? nums2[n - 1] : Integer.MIN_VALUE);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidRightPart(nums1, nums2, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        rightPart = start;
        return (double) (leftPart + rightPart) / 2;
    }

    private boolean isValidRightPart(int[] nums1, int[] nums2, int target) {
        int idx1 = getRightMostIdx(nums1, target);
        int idx2 = getRightMostIdx(nums2, target);
        int count = 0;
        if (idx1 < 0) {
            count += (-idx1 - 1);
        } else {
            count += (idx1 + 1);
        }
        if (idx2 < 0) {
            count += (-idx2 - 1);
        } else {
            count += (idx2 + 1);
        }

        return count >= ((m + n) / 2) + 1;
    }
    // the num of elements smaller or equal than target
    private boolean isValidLeftPart(int[] nums1, int[] nums2, int target) {

        int idx1 = getRightMostIdx(nums1, target);
        int idx2 = getRightMostIdx(nums2, target);
        int count = 0;
        if (idx1 < 0) {
            count += (-idx1 - 1);
        } else {
            count += (idx1 + 1);
        }
        if (idx2 < 0) {
            count += (-idx2 - 1);
        } else {
            count += (idx2 + 1);
        }

        if ((m + n) % 2 == 0) {
            return count >= (m + n) / 2;
        }
        return count >= (m + n + 1) / 2;
    }

    private int getRightMostIdx(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        LC_4 lc_4 = new LC_4();
        int[] nums1 = {0, 0};
        System.out.println(Arrays.binarySearch(nums1, 0));
        int[] nums2 = {0, 0};
        System.out.println(lc_4.findMedianSortedArrays(nums1, nums2));
    }
}
