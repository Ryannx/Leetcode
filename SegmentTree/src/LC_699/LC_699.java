package LC_699;

import java.util.*;

public class LC_699 {
    public List<Integer> fallingSquares(int[][] positions) {

        if (positions == null || positions.length == 0) {
            return new ArrayList<>();
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int[] p : positions) {
            treeSet.add(p[0]);
            treeSet.add(p[0] + p[1]);
        }
        int idx = 0;
        HashMap<Integer, Integer> pos2idx = new HashMap<>();
        for (int p : treeSet) {
            pos2idx.put(p, idx);
            idx++;
        }

        SegTreeNode root = new SegTreeNode(0, treeSet.size() - 1);
        root.initial(root, 0, treeSet.size() - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int start = pos2idx.get(positions[i][0]);
            int end = pos2idx.get(positions[i][0] + positions[i][1]) - 1;
            int curVal = root.queryRange(root, start, end);
            root.updateRange(root, start, end, curVal + positions[i][1]);
            res.add(root.getMax(root));
        }

        return res;
    }

    public static void main(String[] args) {
        LC_699 lc_699 = new LC_699();
        int[][] positions = {{3,1}, {9,7}, {1,9}};
        System.out.println(lc_699.fallingSquares(positions));
    }
}
