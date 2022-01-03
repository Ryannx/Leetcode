package LC_347;

import java.util.*;

public class LC_347 {
    public int[] topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        // [val, count]
        HashMap<Integer, Integer> val2count = new HashMap<>();
        for (int num : nums) {
            int count = val2count.getOrDefault(num, 0);
            val2count.put(num, count + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = (a, b) -> (b.getValue() - a.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(comparator );
        for (Map.Entry<Integer, Integer> entry : val2count.entrySet()) {
            maxHeap.add(entry);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                res[i] = maxHeap.poll().getKey();
            }
        }

        return res;
    }
}
