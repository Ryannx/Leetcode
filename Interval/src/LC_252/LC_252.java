package LC_252;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class LC_252 {
    public boolean canAttendMeetings(int[][] intervals) {

        if (intervals == null) {
            return true;
        }

        List<int[]> pointsList = new ArrayList<>();
        for (int[] interval : intervals) {
            pointsList.add(new int[] {interval[0], -1});
            pointsList.add(new int[] {interval[1], 1});
        }

        Comparator<int[]> comparator = (a, b) -> (a[0] == b[0] ?
                (a[1] == b[1] ? 0 : (a[1] == 1 ? -1 : 1)) : a[0] - b[0]);

        Collections.sort(pointsList, comparator);
        int i = 0;
        int count = 0;
        int len = pointsList.size();
        while (i < len) {
            if (pointsList.get(i)[1] == -1) {
                count++;
                if (count > 1) {
                    return false;
                }
            } else {
                count--;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        LC_252 lc_252 = new LC_252();
        int[][] intervals = {{7, 10}, {2, 4}};
        System.out.println(lc_252.canAttendMeetings(intervals));
    }
}
