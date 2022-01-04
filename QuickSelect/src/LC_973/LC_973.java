package LC_973;

import java.util.ArrayList;
import java.util.List;

public class LC_973 {
    public int[][] kClosest(int[][] points, int k) {

        List<int[]> pointsList = new ArrayList<>();
        // [distance, idx]
        for (int i = 0; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pointsList.add(new int[] {distance, i});
        }

        int kthClosest = quickSelect(pointsList, 0, pointsList.size() - 1, k);

        List<int[]> temp = new ArrayList<>();
        for (int[] point : pointsList) {
            if (point[0] <= kthClosest) {
                temp.add(points[point[1]]);
            }
        }

        int[][] res = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }

        return res;
    }

    private int quickSelect(List<int[]> pointsList, int start, int end, int k) {

        int i = start;
        int t = start;
        int j = end;
        int pivot = pointsList.get(start + (end - start) / 2)[0];
        while (t <= j) {
            if (pointsList.get(t)[0] < pivot) {
                swap(pointsList, t, i);
                i++;
                t++;
            } else if (pointsList.get(t)[0] == pivot) {
                t++;
            } else {
                swap(pointsList, t, j);
                j--;
            }
        }

        if (i - start >= k) {
            return quickSelect(pointsList, start, i - 1, k);
        }
        if (j - start + 1 >= k) {
            return pivot;
        }
        return quickSelect(pointsList, j + 1, end, k - (j - start + 1));
    }

    private void swap(List<int[]> pointsList, int i, int j) {
        int[] temp = pointsList.get(i);
        pointsList.set(i, pointsList.get(j));
        pointsList.set(j, temp);
    }

    public static void main(String[] args) {
        LC_973 lc_973 = new LC_973();
        int[][] points = {{1,3}, {-2,2}};
        lc_973.kClosest(points, 1);
    }
}
