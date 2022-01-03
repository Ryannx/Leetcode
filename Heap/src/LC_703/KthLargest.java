package LC_703;

import java.util.PriorityQueue;

public class KthLargest {

    private int K;
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {

        this.K = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {

        this.minHeap.add(val);
        if (minHeap.size() > this.K) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
