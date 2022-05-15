package LC_499.v2;

import java.util.Objects;
import java.util.PriorityQueue;

public class LC_499v2 {

    private static class Cell implements Comparable {
        private int x, y, distance;
        private String path;
        public Cell(int x, int y, int distance, String path) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.path = path;
        }

        @Override
        public int compareTo(Object o) {
            Cell another = (Cell) o;
            if (this.distance == another.distance) {
                int i = 0;
                int j = 0;
                while (i < this.path.length() && j < another.path.length()) {
                    if (this.path.charAt(i) < another.path.charAt(j)) return -1;
                    if (this.path.charAt(i) > another.path.charAt(j)) return 1;
                    i++;
                    j++;
                }
            } else {
                return this.distance - another.distance;
            }

            return 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, distance);
        }
    }

    private int[][] directions;
    private int m, n;
    private int[] hole;
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

        if (maze == null || ball == null || hole == null) {
            return "";
        }

        this.m = maze.length;
        this.n = maze[0].length;
        this.hole = hole;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        PriorityQueue<Cell> candidates = new PriorityQueue<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        minHeap.add(new Cell(ball[0], ball[1], 0, ""));
        this.directions = new int[][] {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            Cell cur = minHeap.poll();
            if (cur.x == hole[0] && cur.y == hole[1]) {
                candidates.add(cur);
                continue;
            }
            if (visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;
            for (int d = 0; d < directions.length; d++) {
                int step = getStep(cur.x, cur.y, d, maze);
                if (step == 0) continue;
                int nextX = cur.x + step * directions[d][0];
                int nextY = cur.y + step * directions[d][1];
                String c = getCommand(d);
                minHeap.add(new Cell(nextX, nextY, cur.distance + step, cur.path + c));
            }
        }
        if (!candidates.isEmpty()) {
            return candidates.peek().path;
        }
        return "impossible";
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private String getCommand(int d) {
        if (d == 0) return "d";
        if (d == 1) return "l";
        if (d == 2) return "r";
        return "u";
    }

    private int getStep(int x, int y, int d, int[][] maze) {

        int i = 0;
        while (inArea(x + directions[d][0] * (i + 1), y + directions[d][1] * (i + 1))
        && maze[x + directions[d][0] * (i + 1)][y + directions[d][1] * (i + 1)] != 1) {
            i++;
            if (x + directions[d][0] * i == hole[0] && y + directions[d][1] * i == hole[1]) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        LC_499v2 solution = new LC_499v2();
        int[][] maze = {{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
        int[] ball = {4,3};
        int[] hole = {0,1};
        System.out.println(solution.findShortestWay(maze, ball, hole));
    }
}
