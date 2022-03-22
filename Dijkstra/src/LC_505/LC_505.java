package LC_505;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_505 {

    private int row;
    private int col;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        if (maze == null || start == null || destination == null) {
            return -1;
        }

        row = maze.length;
        col = maze[0].length;
        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0]);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);
        boolean[][] solved = new boolean[row][col];
        priorityQueue.add(new int[] {0, start[0], start[1]});
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            int distance = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (solved[r][c]) continue;
            if (r == destination[0] && c == destination[1]) {
                return distance;
            }
            solved[r][c] = true;

            for (int d = 0; d < directions.length; d++) {
                int dist = 0;
                int nextR = r;
                int nextC = c;
                while (inArea(nextR + directions[d][0], nextC + directions[d][1]) && maze[nextR + directions[d][0]][nextC + directions[d][1]] != 1) {
                    dist++;
                    nextR += directions[d][0];
                    nextC += directions[d][1];
                }
                if (solved[nextR][nextC]) continue;
                priorityQueue.add(new int[] {distance + dist, nextR, nextC});
            }
        }

        return -1;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
