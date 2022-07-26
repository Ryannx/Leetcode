package LC_236;

import Library.*;

public class LC_236 {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    private int dfs(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return 0;
        }

        int left = dfs(node.left, p, q);
        int right = dfs(node.right, p, q);
        int self = (node == p || node == q) ? 1 : 0;
        int count = left + right + self;
        if (count == 2 && res == null) {
            res = node;
        }
        return count;
    }
}
