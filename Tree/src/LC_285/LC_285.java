package LC_285;

import Library.TreeNode;

public class LC_285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode cur = root;
        TreeNode res = null;
        while (cur != null) {
            if (cur.val > p.val) {
                res = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return res;
    }
}
