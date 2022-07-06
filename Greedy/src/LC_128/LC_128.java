package LC_128;

import java.util.*;

public class LC_128 {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int res = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int next = num;
                int curLen = 0;
                while (set.contains(next)) {
                    next++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
