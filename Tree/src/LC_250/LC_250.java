package LC_250;

import Library.TreeNode;

public class LC_250 {
    public int countUnivalSubtrees(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] count = new int[1];
        dfs(root, count);
        return count[0];
    }

    private boolean dfs(TreeNode node, int[] count) {

        if (node == null) {
            return true;
        }

        boolean left = dfs(node.left, count);
        boolean right = dfs(node.right, count);
        if (left && right) {
            if (node.left != null && node.right != null) {
                if (node.val == node.left.val && node.val == node.right.val) {
                    count[0]++;
                    return true;
                }
            } else if (node.left != null) {
                if (node.val == node.left.val) {
                    count[0]++;
                    return true;
                }
            } else if (node.right != null) {
                if (node.val == node.right.val) {
                    count[0]++;
                    return true;
                }
            } else {
                count[0]++;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC_250 lc_250 = new LC_250();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(5);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(5);
        root.right = new TreeNode(1);
//        root.right.right = new TreeNode(5);
        System.out.println(lc_250.countUnivalSubtrees(root));
    }
}
