package LC_818;

import java.util.*;

public class LC_818 {

    private static class Cell {
        private int pos, speed;
        public Cell(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pos, speed);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Cell)) {
                return false;
            }
            Cell other = (Cell) obj;
            return this.pos == other.pos && this.speed == other.speed;
        }
    }
    public int racecar(int target) {

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 1));
        int res = 0;
        HashSet<Cell> visited = new HashSet<>();
        visited.add(new Cell(0, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Cell cur = queue.poll();
                // A
                Cell next = new Cell(cur.pos + cur.speed, cur.speed * 2);
                if (next.pos == target) {
                    return res + 1;
                }
                if (!visited.contains(next) && Math.abs(next.pos - target) < target) {
                    visited.add(next);
                    queue.add(next);
                }
                // R
                int nextSpeed = cur.speed > 0 ? -1 : 1;
                next = new Cell(cur.pos, nextSpeed);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
            res++;
        }

        return -1;
    }
}
