package LC_538.v2;

import Library.TreeNode;
public class LC_538 {
    public TreeNode convertBST(TreeNode root) {

        int[] sum = new int[1];
        inorderTravers(root, sum);
        return root;
    }

    private void inorderTravers(TreeNode node, int[] sum) {

        if (node == null) {
            return;
        }

        inorderTravers(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        inorderTravers(node.left, sum);
    }
}
