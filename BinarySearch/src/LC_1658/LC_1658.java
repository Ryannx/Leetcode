package LC_1658;

import java.util.*;

public class LC_1658 {
    public int minOperations(int[] nums, int x) {

        if (nums == null || nums.length == 0 || x == 0) {
            return 0;
        }

        int n = nums.length;
        int[] preSumLeft2Right = new int[n];
        int[] preSumRight2Left = new int[n];
        preSumLeft2Right[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSumLeft2Right[i] = preSumLeft2Right[i - 1] + nums[i];
        }
        preSumRight2Left[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            preSumRight2Left[i] = preSumRight2Left[i + 1] + nums[i];
        }

        int res = Integer.MAX_VALUE / 2;
        // pick from left
        for (int i = 0; i < n; i++) {
            int temp = x - preSumLeft2Right[i];
            if (temp == 0) {
                res = Math.min(res, i + 1);
                break;
            }
            if (temp > 0) {
                int rightIdx = Arrays.binarySearch(preSumRight2Left, temp);
                if (rightIdx <= i || n - rightIdx >= res) continue;
                if (rightIdx > 0) {
                    res = Math.min(res, i + 1 + n - rightIdx);
                }
            } else {
                break;
            }
        }

        // pick from right
        for (int i = n - 1; i >= 0; i--) {
            int temp = x - preSumRight2Left[i];
            if (temp == 0) {
                res = Math.min(res, n - i);
                break;
            }
            if (temp > 0) {
                int leftIdx = Arrays.binarySearch(preSumLeft2Right, temp);
                if (leftIdx >= i || leftIdx >= res) continue;
                if (leftIdx > 0) {
                    res = Math.min(res, n - i + leftIdx + 1);
                }
            } else {
                break;
            }
        }

        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}
