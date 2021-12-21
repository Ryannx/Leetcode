package LC_124;

import Library.*;

public class LC_124 {
    public int maxPathSum(TreeNode root) {

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfs(root, max);
        return max[0];
    }

    // 包含当前结点的单边路径最大值
    private int dfs(TreeNode node, int[] max) {

        if (node == null) {
            return 0;
        }

        int curMax = node.val;
        int left = dfs(node.left, max);
        int right = dfs(node.right, max);
        curMax = Math.max(curMax, Math.max(left + curMax, right + curMax));
        max[0] = Math.max(max[0], Math.max(curMax, node.val + left + right));

        return curMax;
    }
}
