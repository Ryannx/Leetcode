package LC_114;

import Library.TreeNode;
public class LC_114 {
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null) {
            flatten(root.right);
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(root.left);
        flatten(root.right);
        root.left = null;
        root.right = left;
        TreeNode cur = left;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
