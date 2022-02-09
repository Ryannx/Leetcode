package LC_1218;

import java.util.HashMap;

public class LC_1218 {
    public int longestSubsequence(int[] arr, int difference) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> val2len = new HashMap<>();
        int maxLen = 1;
        for (int num : arr) {
            Integer len = val2len.get(num - difference);
            if (len != null) {
                val2len.put(num, len + 1);
                maxLen = Math.max(maxLen, len + 1);
            } else {
                val2len.put(num, 1);
            }
        }

        return maxLen;
    }
}
