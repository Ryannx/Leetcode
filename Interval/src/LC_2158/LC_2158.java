package LC_2158;

import java.util.*;

public class LC_2158 {

    private static class Cell {
        private int idx, pos, isStart;

        public Cell() {}
        public Cell(int idx, int pos, int isStart) {
            this.idx = idx;
            this.pos = pos;
            this.isStart = isStart;
        }

    }
    public int[] amountPainted(int[][] paint) {

        if (paint == null) {
            return null;
        }

        Comparator<Cell> c1 = (a, b) -> (a.pos == b.pos ? (b.isStart == a.isStart ? a.idx - b.idx : b.isStart - a.isStart) : a.pos - b.pos);
        List<Cell> list = new ArrayList<>(); // [idx, pos, isStart]
        for (int i = 0; i < paint.length; i++) {
            list.add(new Cell(i, paint[i][0], -1));
            list.add(new Cell(i, paint[i][1], 1));
        }
        Collections.sort(list, c1);

        Comparator<Cell> c2 = (a, b) -> (a.idx == b.idx ? a.isStart - b.isStart : a.idx - b.idx);
        TreeSet<Cell> treeSet = new TreeSet<>(c2);
        int i = 0;
        int j = 0;
        int[] res = new int[paint.length];
        while (i < list.size() && j < list.size()) {
            while (j < list.size() && list.get(i).pos == list.get(j).pos) {
                if (list.get(j).isStart == -1) {
                    treeSet.add(list.get(j));
                } else {
                    int curIdx = list.get(j).idx;
                    treeSet.remove(new Cell(curIdx, paint[curIdx][0], -1));
                }
                j++;
            }
            if (!treeSet.isEmpty()) {
                res[treeSet.first().idx] += list.get(j).pos - list.get(i).pos;
            }
            i = j;
        }

        return res;
    }

    public static void main(String[] args) {
        LC_2158 lc_2158 = new LC_2158();
        int[][] paints = {{1,4}, {4,7}, {5,8}};
        int[] res = lc_2158.amountPainted(paints);
        for (int n : res) {
            System.out.println(n);
        }
    }
}
