package LC_1696;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_1696 {
    public int maxResult(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {nums[0], 0});
        for (int i = 1; i < n; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst()[1] > k) {
                deque.pollFirst();
            }
            int curStep = deque.peekFirst()[0] + nums[i];
            while (!deque.isEmpty() && curStep > deque.peekLast()[0]) {
                deque.pollLast();
            }
            deque.add(new int[] {curStep, i});
        }
        return deque.peekLast()[0];
    }
}
