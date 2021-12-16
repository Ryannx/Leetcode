package LC_57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals == null || newInterval == null) {
            return null;
        }

        List<int[]> pointsList = new ArrayList<>();
        for (int[] interval : intervals) {
            pointsList.add(new int[] {interval[0], -1});
            pointsList.add(new int[] {interval[1], 1});
        }
        pointsList.add(new int[] {newInterval[0], -1});
        pointsList.add(new int[] {newInterval[1], 1});

        Comparator<int[]> comparator = (a, b) -> (a[0] == b[0] ?
                (a[1] == b[1] ? 0 : (a[1] == -1 ? -1 : 1)) : a[0] - b[0]);
        Collections.sort(pointsList, comparator);

        int start = 0;
        int end = 0;
        int count = 0;
        List<int[]> intervalList = new ArrayList<>();
        for (int[] point : pointsList) {
            if (point[1] == -1) {
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
}
