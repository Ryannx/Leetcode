package LC_563;

public class LC_563 {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findTilt(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] tilt = new int[1];
        dfs(root, tilt);
        return tilt[0];
    }

    // dfs: 表示当前结点的sum
    private int dfs(TreeNode node, int[] tilt) {

        if (node.left == null && node.right == null) {
            return node.val;
        }

        if (node.left != null && node.right != null) {
            int l = dfs(node.left, tilt);
            int r = dfs(node.right, tilt);
            tilt[0] += Math.abs(l - r);
            return l + r + node.val;
        } else if (node.left != null) {
            int l = dfs(node.left, tilt);
            tilt[0] += Math.abs(l);
            return l + node.val;
        } else {
            int r = dfs(node.right, tilt);
            tilt[0] += Math.abs(r);
            return r + node.val;
        }
    }

    public static void main(String[] args) {
        LC_563 lc_563 = new LC_563();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(lc_563.findTilt(root));
    }
}
