package LC_539;

import java.util.*;

public class LC_539 {
    public int findMinDifference(List<String> timePoints) {

        if (timePoints == null || timePoints.size() == 0) {
            return 0;
        }

        boolean[] visited = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] cur = time.split(":");
            int curMinutes = Integer.parseInt(cur[0]) * 60 + Integer.parseInt(cur[1]);
            if (visited[curMinutes]) {
                return 0;
            }
            visited[curMinutes] = true;
        }

        int earliest = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        int prevTime = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                continue;
            }
            if (prevTime != -1) {
                res = Math.min(res, i - prevTime);
            }
            earliest = Math.min(earliest, i);
            last = Math.max(last, i);
            prevTime = i;
        }

        res = Math.min(res, earliest + 24 * 60 - last);
        return res;
    }

    public static void main(String[] args) {
        LC_539 lc_539 = new LC_539();
        List<String> timePoints = Arrays.asList("01:39","10:26","21:43");
        System.out.println(lc_539.findMinDifference(timePoints));
    }
}
