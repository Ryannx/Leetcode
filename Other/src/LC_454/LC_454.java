package LC_454;

import LC_418.LC_418;

import java.util.*;

public class LC_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int n = nums1.length;
        HashMap<Integer, Integer> val2amount1 = innitalMap(nums1, nums2);
        HashMap<Integer, Integer> val2amount2 = innitalMap(nums3, nums4);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : val2amount1.entrySet()) {
            int curVal = entry.getKey();
            Integer anotherAmount = val2amount2.get(-curVal);
            if (anotherAmount != null) {
                count += (entry.getValue() * anotherAmount);
            }
        }
        return count;
    }

    private HashMap<Integer, Integer> innitalMap(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> val2amount = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curSum = nums1[i] + nums2[j];
                Integer amount = val2amount.getOrDefault(curSum, 0);
                amount++;
                val2amount.put(curSum, amount);
            }
        }
        return val2amount;
    }

    public static void main(String[] args) {
        LC_454 lc_454 = new LC_454();
        int[] nums1 = {-1, -1};
        int[] nums2 = {-1, 1};
        int[] nums3 = {-1, 1};
        int[] nums4 = {1, -1};
        System.out.println(lc_454.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
