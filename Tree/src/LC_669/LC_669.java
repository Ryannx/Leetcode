package LC_669;

import Library.TreeNode;

public class LC_669 {

    private int low;
    private int high;
    private TreeNode newRoot;

    public TreeNode trimBST(TreeNode root, int low, int high) {

        this.low = low;
        this.high = high;

        dfs(root);
        return newRoot;
    }

    private void dfs(TreeNode node) {

        if (node == null) {
            return;
        }

        if (low <= node.val && node.val <= high) {
            updateTree(newRoot, node.val);
        }
        dfs(node.left);
        dfs(node.right);
    }

    private void updateTree(TreeNode node, int val) {

        if (newRoot == null) {
            newRoot = new TreeNode(val);
            return;
        }

        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return;
            }
            updateTree(node.left, val);
        }
        if (val > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return;
            }
            updateTree(node.right, val);
        }
    }
}
