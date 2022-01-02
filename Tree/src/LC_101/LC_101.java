package LC_101;

import Library.TreeNode;

public class LC_101 {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode leftNode, TreeNode rightNode) {

        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        return (leftNode.val == rightNode.val) && dfs(leftNode.left, rightNode.right) && dfs(leftNode.right, rightNode.left);
    }
}
