package LC_218;

import java.util.*;

public class LC_218 {

    private static class Cell implements Comparable {
        private int idx;
        private int pos;
        private int height;
        private int isStart;

        public Cell() {}
        public Cell(int idx, int pos, int height, int isStart) {
            this.idx = idx;
            this.pos = pos;
            this.height = height;
            this.isStart = isStart;
        }
        public Cell(Cell cell) {
            this.idx = cell.idx;
            this.pos = cell.pos;
            this.height = cell.height;
            this.isStart = cell.isStart;
        }

        @Override
        public int compareTo(Object o) {
            Cell other = (Cell) o;
            if (this.height != other.height) {
                return this.height - other.height;
            }
            if (this.isStart == other.isStart) {
                return this.pos - other.pos;
            }
            return other.isStart - this.isStart;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }

        List<Cell> list = new ArrayList<>(); // [pos, height, isStart]
        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            list.add(new Cell(i, b[0], b[2], -1));
            list.add(new Cell(i, b[1], b[2], 1));
        }
        Comparator<Cell> comparator = (a, b) -> (a.pos == b.pos ? a.isStart - b.isStart : a.pos - b.pos);
        Collections.sort(list, comparator);

        TreeSet<Cell> treeSet = new TreeSet<>();
        List<int[]> candidates = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list.size() && j < list.size()) {
            while (j < list.size() && list.get(i).pos == list.get(j).pos) {
                if (list.get(j).isStart == -1) {
                    treeSet.add(list.get(j));
                } else {
                    treeSet.remove(new Cell(list.get(j).idx, buildings[list.get(j).idx][0], list.get(j).height, -list.get(j).isStart));
                }
                j++;
            }
            if (treeSet.isEmpty()) {
                candidates.add(new int[] {list.get(i).pos, 0});
                i = j;
                continue;
            }
            Cell cur = treeSet.last();
            candidates.add(new int[] {list.get(i).pos, cur.height});
            i = j;
        }

        // merge
        for (int[] c : candidates) {
            if (res.size() == 0 || res.get(res.size() - 1).get(1) != c[1]) {
                res.add(Arrays.asList(c[0], c[1]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_218 lc_218 = new LC_218();
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(lc_218.getSkyline(buildings));
    }
}
