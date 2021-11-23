package LC_450;

import Library.TreeNode;

public class LC_450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        return dfs(root, key);
    }

    private TreeNode dfs(TreeNode cur, int key) {

        if (cur == null) {
            return null;
        }

        if (key < cur.val) {
            cur.left = dfs(cur.left, key);
        } else if (key > cur.val) {
            cur.right = dfs(cur.right, key);
        } else {
            if (cur.left == null && cur.right == null) {
                cur = null;
            } else if (cur.left != null) {
                int max = getMax(cur.left);
                cur.val = max;
                cur.left = dfs(cur.left, max);
            } else {
                int min = getMin(cur.right);
                cur.val = min;
                cur.right = dfs(cur.right, min);
            }
        }

        return cur;
    }

    private int getMax(TreeNode node) {

        TreeNode cur = node;
        int res = 0;
        while (cur != null) {
            res = cur.val;
            cur = cur.right;
        }

        return res;
    }

    private int getMin(TreeNode node) {

        TreeNode cur = node;
        int res = 0;
        while (cur != null) {
            res = cur.val;
            cur = cur.left;
        }

        return res;
    }
}
