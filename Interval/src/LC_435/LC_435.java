package LC_435;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_435 {

    private static class Cell implements Comparable<Cell> {
        private int start;
        private int end;
        public Cell(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Cell cell) {
            return Integer.compare(this.end, cell.end);
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }

        List<Cell> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new Cell(interval[0], interval[1]));
        }
        Collections.sort(list);

        int i = 0;
        int len = intervals.length;
        int count = 0;

        while (i < len) {
            int j = i + 1;
//            count++;
            while (j < len && list.get(j).start < list.get(i).end) {
                j++;
            }
            count++;
            i = j;
        }

        return len - count;
    }

    public static void main(String[] args) {
        LC_435 lc_435 = new LC_435();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(lc_435.eraseOverlapIntervals(intervals));
    }
}
