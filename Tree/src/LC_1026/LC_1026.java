package LC_1026;

import Library.*;

public class LC_1026 {
    public int maxAncestorDiff(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int curMin, int curMax) {

        if (node == null) {
            return curMax - curMin;
        }

        curMin = Math.min(curMin, node.val);
        curMax = Math.max(curMax, node.val);
        int left = dfs(node.left, curMin, curMax);
        int right = dfs(node.right, curMin, curMax);
        return Math.max(left, right);
    }
}
