package LC_759;

import java.util.*;

public class LC_759 {
    private static class Interval {
        private int start;
        private int end;
        public Interval() {}
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        if (schedule == null) {
            return null;
        }

        List<int[]> pointsList = new ArrayList<>();
        for (List<Interval> person : schedule) {
            for (Interval interval : person) {
                pointsList.add(new int[] {interval.start, -1});
                pointsList.add(new int[] {interval.end, 1});
            }
        }
        Comparator<int[]> comparator = (a, b) -> (a[0] == b[0] ?
                (a[1] == b[1] ? 0 : (a[1] == -1 ? -1 : 1)) : a[0] - b[0]);

        Collections.sort(pointsList, comparator);

        int start = -1;
        int end = 0;
        int count = 0;
        List<Interval> res = new ArrayList<>();
        for (int[] point : pointsList) {
            if (point[1] == -1) {
                count++;
                if (count == 1 && start != -1) {
                    end = point[0];
                    res.add(new Interval(start, end));
                }
            } else {
                count--;
                if (count == 0) {
                    start = point[0];
                }
            }
        }

        return res;
    }
}
