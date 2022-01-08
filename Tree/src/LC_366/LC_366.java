package LC_366;

import java.util.*;
import Library.*;

public class LC_366 {
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeMap<Integer, List<Integer>> lvl2val = new TreeMap<>();
        getHight(root, lvl2val);

        for (Map.Entry<Integer, List<Integer>> entry : lvl2val.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    private int getHight(TreeNode node, TreeMap<Integer, List<Integer>> lvl2val) {

        if (node == null) {
            return -1;
        }

        int left = getHight(node.left, lvl2val);
        int right = getHight(node.right, lvl2val);
        int curHigh = Math.max(left, right) + 1;
        List<Integer> val = lvl2val.getOrDefault(curHigh, new ArrayList<>());
        val.add(node.val);
        lvl2val.put(curHigh, val);
        return curHigh;
    }
}
