package LC_2342;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_2342 {
    public int maximumSum(int[] nums) {

        int n = nums.length;
        Comparator<Integer> comparator = (a, b) -> (b - a);
        HashMap<Integer, PriorityQueue<Integer>> sum2nums = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sumOfDigits = getSumOfDigigts(nums[i]);
            PriorityQueue<Integer> maxHeap = sum2nums.getOrDefault(sumOfDigits, new PriorityQueue<>(comparator));
            maxHeap.add(nums[i]);
            sum2nums.put(sumOfDigits, maxHeap);
        }

        long res = -1;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : sum2nums.entrySet()) {
            if (entry.getValue().size() < 2) continue;
            res = Math.max(res, (long) (entry.getValue().poll() + entry.getValue().poll()));
        }

        return (int) res;
    }

    private int getSumOfDigigts(int num) {
        int cur = num;
        int sum = 0;
        while (cur != 0) {
            sum += cur % 10;
            cur /= 10;
        }
        return sum;
    }
}
