package LC_1354;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1354 {
    public boolean isPossible(int[] target) {

        if (target == null || target.length == 0) {
            return true;
        }

        long sum = 0;
        Comparator<Long> comparator = (a, b) -> (Long.compare(b, a));
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(comparator);
        for (int num : target) {
            sum += num;
            maxHeap.add((long) num);
        }

        while (maxHeap.peek() != 1) {
            long a = maxHeap.poll();
            long other = sum - a;
            if (a <= other || other == 0) return false;
            long b = a % other;
            if (b == 0 && other != 1) return false;
            maxHeap.add(b);
            sum = other + b;
        }

        return true;
    }

    public static void main(String[] args) {
        LC_1354 lc_1354 = new LC_1354();
        int[] taget = {1,1,4};
        System.out.println(lc_1354.isPossible(taget));
    }
}
