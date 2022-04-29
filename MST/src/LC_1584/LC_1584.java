package LC_1584;

import UF.*;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1584 {
    public int minCostConnectPoints(int[][] points) {

        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }

        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator); // [distance, i, j]
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                minHeap.add(new int[] {distance, i, j});
            }
        }

        int n = points.length;
        UnionFind uf = new UnionFind(n);
        int res = 0;
        int count = 0;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll(); // [distance, i, j]
            if (uf.find(cur[1], cur[2])) continue;
            res += cur[0];
            count++;
            uf.union(cur[1], cur[2]);
            if (count == n - 1) {
                return res;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LC_1584 lc_1584 = new LC_1584();
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(lc_1584.minCostConnectPoints(points));
    }
}
