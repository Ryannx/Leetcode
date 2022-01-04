package LC_253;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC_253 {
    public int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        List<int[]> pointsList = new ArrayList<>();
        for (int[] interval : intervals) {
            pointsList.add(new int[] {interval[0], -1});
            pointsList.add(new int[] {interval[1], 1});
        }

        Comparator<int[]> comparator = (a, b) -> (a[0] == b[0] ?
                (a[1] == b[1] ? 0 : (a[1] == 1 ? -1 : 1)) : a[0] - b[0]);
        Collections.sort(pointsList, comparator);

        int count = 0;
        int res = 0;
        int i = 0;
        while (i < pointsList.size()) {
            if (pointsList.get(i)[1] == -1) {
                count++;
                res = Math.max(res, count);
            } else {
                count--;
            }
            i++;
        }

        return res;
    }
}
