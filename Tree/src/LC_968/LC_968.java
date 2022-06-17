package LC_968;

import Library.*;

public class LC_968 {
    public int minCameraCover(TreeNode root) {

        int[] res = new int[1];
        // 0: uncover
        // 1: camera
        // 2: covered
        int temp = dfs(root, res);
        if (temp == 0) {
            res[0]++;
        }
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {

        if (node == null) {
            return 2;
        }

        int left = dfs(node.left, res);
        int right = dfs(node.right, res);
        if (left == 0 || right == 0) {
            res[0]++;
            return 1;
        }
        if (left == 2 && right == 2) {
            return 0;
        }
        return 2;
    }
}
