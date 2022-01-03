package LC_295;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private int size;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        this.size = 0;
    }

    public void addNum(int num) {

        if (minHeap.isEmpty() || minHeap.peek() < num) {
            minHeap.add(num);
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        } else {
            maxHeap.add(num);
            if (maxHeap.size() - minHeap.size() >= 1) {
                minHeap.add(maxHeap.poll());
            }
        }
        size++;
    }

    public double findMedian() {

        if (size % 2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }
}
