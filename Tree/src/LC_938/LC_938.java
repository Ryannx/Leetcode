package LC_938;

import Library.*;

public class LC_938 {
    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null || low > high) {
            return 0;
        }

        int[] sum = new int[1];
        dfs(root, low, high, sum);
        return sum[0];
    }

    private void dfs(TreeNode node, int low, int high, int[] sum) {

        if (node == null) {
            return;
        }

        if (node.val >= low && node.val <= high) {
            sum[0] += node.val;
        }
        if (node.val > low) {
            dfs(node.left, low, high, sum);
        }
        if (node.val < high) {
            dfs(node.right, low, high, sum);
        }
    }

    public static void main(String[] args) {
        LC_938 lc_938 = new LC_938();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(lc_938.rangeSumBST(root, 7, 15));
    }
}
