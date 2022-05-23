package LC_2279;

import java.util.*;

public class LC_2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        if (capacity == null || rocks == null) {
            return -1;
        }

        int n = capacity.length;
        TreeMap<Integer, Integer> val2amount = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int amount = val2amount.getOrDefault(capacity[i] - rocks[i], 0);
            amount++;
            val2amount.put(capacity[i] - rocks[i], amount);
        }

        int count = 0;
        int curRocks = additionalRocks;
        for (Map.Entry<Integer, Integer> entry : val2amount.entrySet()) {
            if (entry.getKey() == 0) {
                count += entry.getValue();
                continue;
            }
            int curNeed = entry.getKey();
            int curAmount = entry.getValue();
            while (curRocks - curNeed >= 0 && curAmount > 0) {
                curRocks -= curNeed;
                curAmount--;
                count++;
            }
        }
        return count;
    }
}
