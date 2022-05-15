package LC_499.v1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_499 {

    // [distance, path, r, c]
    private static class Cell implements Comparable {
        private int distance;
        private String path;
        private int r, c;

        public Cell (int distance, String path, int r, int c) {
            this.distance = distance;
            this.path = path;
            this.r = r;
            this.c = c;
        }

        public Cell() {}

        @Override
        public int compareTo(Object o) {
            Cell other = (Cell) o;
            if (this.distance == other.distance) {
                int i = 0;
                int j = 0;
                while (i < this.path.length() && j < other.path.length()) {
                    if (this.path.charAt(i) < other.path.charAt(j)) return -1;
                    if (this.path.charAt(i) > other.path.charAt(j)) return 1;
                    i++;
                    j++;
                }
            }
            return this.distance - other.distance;
        }
    }
    private int row;
    private int col;
    private int[][] directions;

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

        if (maze == null || maze.length == 0 || maze[0].length == 0
                || ball == null || ball.length == 0 || hole == null || hole.length == 0) {
            return "";
        }

        row = maze.length;
        col = maze[0].length;
        directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.add(new Cell(0, "", ball[0], ball[1]));
        Integer[][] dist = new Integer[row][col];
        dist[ball[0]][ball[1]] = 0;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.reverseOrder());

        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            if (dist[cur.r][cur.c] != null && cur.distance > dist[cur.r][cur.c]) continue;
            for (int d = 0; d < directions.length; d++) {
                int step = caculateStep(maze, hole, d, cur.r, cur.c);
                if (step == 0) continue;
                int nextR = cur.r + step * directions[d][0];
                int nextC = cur.c + step * directions[d][1];
                String nextCommend = getCommend(d);
                if (nextR == hole[0] && nextC == hole[1]) {
                    minHeap.add(new Cell(cur.distance + step, cur.path + nextCommend, nextR, nextC));
                    if (minHeap.size() > 1) {
                        minHeap.poll();
                    }
                    break;
                }
                // 入队更新
                int nextDistance = cur.distance + step;
                if (dist[nextR][nextC] != null && nextDistance > dist[nextR][nextC]) continue;
                dist[nextR][nextC] = nextDistance;
                pq.add(new Cell(nextDistance, cur.path + nextCommend, nextR, nextC));
            }
        }

        if (minHeap.isEmpty()) return "impossible";
        return minHeap.peek().path;
    }

    private String getCommend(int d) {
        if (d == 0) return "u";
        if (d == 1) return "l";
        if (d == 2) return "d";
        return "r";
    }

    private int caculateStep(int[][] maze, int[] hole, int d, int r, int c) {

        int i = r;
        int j = c;
        int step = 0;
        while (inArea(i + directions[d][0], j + directions[d][1])
                && maze[i + directions[d][0]][j + directions[d][1]] != 1
                && !arrived(hole, i + directions[d][0], j + directions[d][1])) {
            i += directions[d][0];
            j += directions[d][1];
            step++;
        }
        if (arrived(hole, i + directions[d][0], j + directions[d][1])) return step + 1;
        return step;
    }

    private boolean arrived(int[] hole, int i, int j) {
        return i == hole[0] && j == hole[1];
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        LC_499 lc_499 = new LC_499();
        int[][] maze = {{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
        int[] ball = {4,3};
        int[] hole = {0,1};
        System.out.println(lc_499.findShortestWay(maze, ball, hole));
    }
}
