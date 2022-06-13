package LC_1197;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LC_1197 {

    public int minKnightMoves(int x, int y) {

        if (x == 0 && y == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        int base = 300;
        boolean[][] visited = new boolean[700][700];
        visited[base][base] = true;
        int step = 0;
        int[][] directions = {{-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int d = 0; d < directions.length; d++) {
                    int nextX = cur[0] + directions[d][0];
                    int nextY = cur[1] + directions[d][1];
                    if (nextX == x && nextY == y) {
                        return step + 1;
                    }
                    if (!inArea(nextX, nextY) || visited[nextX + base][nextY + base]) continue;
                    visited[nextX + base][nextY + base] = true;
                    queue.add(new int[] {nextX, nextY});
                }
            }
            step++;
        }

        return -1;
    }

    private boolean inArea(int x, int y) {
        return Math.abs(x) + Math.abs(y) >= 0 && Math.abs(x) + Math.abs(y) <= 300 && x >= -300 && y >= -300
                && x <= 300 && y <= 300;
    }
}
