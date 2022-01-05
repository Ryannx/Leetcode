package LC_298;

import Library.TreeNode;

import java.util.Collection;
import java.util.Collections;

public class LC_298 {
    public int longestConsecutive(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] res = new int[1];
        res[0] = 1;
        dfs(root, Integer.MIN_VALUE, 1, res);
        return res[0];
    }

    private void dfs(TreeNode node, int lastVal, int curLen, int[] res) {

        if (node == null) {
            return;
        }

        if (node.val == lastVal + 1) {
            res[0] = Math.max(res[0], curLen + 1);
            dfs(node.left, node.val, curLen + 1, res);
            dfs(node.right, node.val, curLen + 1, res);
        } else {
            dfs(node.left, node.val, 1, res);
            dfs(node.right, node.val, 1, res);
        }
    }
}
