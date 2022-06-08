package LC_947;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_947 {
    public int removeStones(int[][] stones) {

        if (stones == null) {
            return 0;
        }

        HashMap<Integer, List<Integer>> row2listCol = new HashMap<>();
        HashMap<Integer, List<Integer>> col2listRow = new HashMap<>();
        for (int[] stone : stones) {
            List<Integer> listCol = row2listCol.getOrDefault(stone[0], new ArrayList<>());
            listCol.add(stone[1]);
            row2listCol.put(stone[0], listCol);
            List<Integer> listRow = col2listRow.getOrDefault(stone[1], new ArrayList<>());
            listRow.add(stone[0]);
            col2listRow.put(stone[1], listRow);
        }

        int base = (int) 1e4 + 7;
        UnionFind uf = new UnionFind(base);
        uf.initial(stones);
        for (Map.Entry<Integer, List<Integer>> entry : row2listCol.entrySet()) {
            int prev = -1;
            for (int col : entry.getValue()) {
                if (prev == -1) {
                    prev = entry.getKey() * base + col;
                    continue;
                }
                int cur = entry.getKey() * base + col;
                if (!uf.find(prev,cur)) {
                    uf.union(prev, cur);
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : col2listRow.entrySet()) {
            int prev = -1;
            for (int row : entry.getValue()) {
                if (prev == -1) {
                    prev = row * base + entry.getKey();
                    continue;
                }
                int cur = row * base + entry.getKey();
                if (!uf.find(prev,cur)) {
                    uf.union(prev, cur);
                }
            }
        }

        return stones.length - uf.getCcAmount();
    }

    public static void main(String[] args) {
        LC_947 lc_947 = new LC_947();
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(lc_947.removeStones(stones));
    }
}
