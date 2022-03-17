package LC_407;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_407 {

    private int row;
    private int col;

    public int trapRainWater(int[][] heightMap) {

        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        row = heightMap.length;
        col = heightMap[0].length;

        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0]);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || i == row - 1 || j == 0 || j == col - 1) && !visited[i][j]) {
                    priorityQueue.add(new int[] {heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }

        int res = 0;
        int lvl = Integer.MIN_VALUE;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            int high = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (lvl < high) {
                lvl = high;
            }
            res += (lvl - high);
            for (int d = 0; d < directions.length; d++) {
                int nextR = r + directions[d][0];
                int nextC = c + directions[d][1];
                if (inArea(nextR, nextC) && !visited[nextR][nextC]) {
                    priorityQueue.add(new int[] {heightMap[nextR][nextC], nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }

        return res;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        LC_407 lc_407 = new LC_407();
        int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println(lc_407.trapRainWater(heightMap));
    }
}
