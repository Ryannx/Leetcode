package LC_630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_630 {
    public int scheduleCourse(int[][] courses) {

        if (courses == null || courses.length == 0) {
            return 0;
        }

        Comparator<int[]> comparator1 = (a, b) -> (a[1] - b[1]);
        Arrays.sort(courses, comparator1);
        Comparator<Integer> comparator2 = (a, b) -> (b - a);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator2);
        int days = 0;
        for (int i = 0; i < courses.length; i++) {
            days += courses[i][0];
            maxHeap.add(courses[i][0]);
            if (days > courses[i][1]) {
                days -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}
