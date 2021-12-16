package LC_56;

import java.util.*;

public class LC_56 {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return null;
        }

        List<int[]> pointsList = new ArrayList<>();
        for (int[] interval : intervals) {
            pointsList.add(new int[] {interval[0], 1});
            pointsList.add(new int[] {interval[1], -1});
        }
        Comparator<int[]> comparator = (a, b) -> (a[0] == b[0] ?
                (a[1] == b[1] ? 0 : (a[1] == 1 ? -1 : 1)) : a[0] - b[0]);

        Collections.sort(pointsList, comparator);

        List<int[]> intervalList = new ArrayList<>();
        int count = 0;
        int start = 0;
        int end = 0;
        for (int[] point : pointsList) {
            if (point[1] == 1) {
                count++;
                if (count == 1) {
                    start = point[0];
                }
            } else {
                count--;
                if (count == 0) {
                    end = point[0];
                    intervalList.add(new int[] {start, end});
                }
            }
        }

        int len = intervalList.size();
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i] = intervalList.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        LC_56 lc_56 = new LC_56();
        int[][] intervals = {{1, 4}, {4, 5}};
        System.out.println(lc_56.merge(intervals));
    }
}
