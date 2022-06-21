package LC_1642;

import java.util.PriorityQueue;

public class LC_1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        if (heights == null || heights.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] - heights[i - 1] <= 0) continue;
            if (count < ladders) {
                count++;
                minHeap.add(heights[i] - heights[i - 1]);
            } else {
                minHeap.add(heights[i] - heights[i - 1]);
                if (bricks < minHeap.peek()) {
                    return i - 1;
                }
                bricks -= minHeap.poll();
            }
        }

        return heights.length - 1;
    }

    public static void main(String[] args) {
        LC_1642 lc_1642 = new LC_1642();
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(lc_1642.furthestBuilding(heights, bricks, ladders));
    }
}
