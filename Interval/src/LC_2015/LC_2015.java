package LC_2015;

import java.util.*;

public class LC_2015 {
    public int[][] averageHeightOfBuildings(int[][] buildings) {

        if (buildings == null) {
            return null;
        }

        TreeMap<Integer, int[]> points = new TreeMap<>(); // [pos, [totalHeight, totalCount]]
        for (int[] b : buildings) {
            int[] arr1 = points.getOrDefault(b[0], new int[] {0, 0});
            arr1[0] += b[2];
            arr1[1] += 1;
            points.put(b[0], arr1);
            int[] arr2 = points.getOrDefault(b[1], new int[] {0, 0});
            arr2[0] -= b[2];
            arr2[1] -= 1;
            points.put(b[1], arr2);
        }

        int totalHeight = 0;
        int totalCount = 0;
        List<int[]> temp = new ArrayList<>(); // [pos, avg]
        for (Map.Entry<Integer, int[]> entry : points.entrySet()) {
            totalHeight += entry.getValue()[0];
            totalCount += entry.getValue()[1];
            int avg = totalCount == 0 ? 0 : totalHeight / totalCount;
            temp.add(new int[] {entry.getKey(), avg});
        }

        int i = 0;
        List<int[]> res = new ArrayList<>();
        while (i < temp.size()) {
            int j = i;
            while (j < temp.size() && temp.get(j)[1] == temp.get(i)[1]) {
                j++;
            }
            if (temp.get(i)[1] == 0) {
                i = j;
                continue;
            }
            res.add(new int[] {temp.get(i)[0], temp.get(j)[0], temp.get(i)[1]});
            i = j;
        }

        int[][] ans = new int[res.size()][3];
        for (int k = 0; k < ans.length; k++) {
            ans[k] = Arrays.copyOf(res.get(k), res.get(k).length);
        }
        return ans;
    }
}
