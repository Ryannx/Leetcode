package LC_1123;

import Library.TreeNode;

public class LC_1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        TreeNode cur = root;
        while (true) {
            int[] max1 = new int[1];
            int[] max2 = new int[1];
            int leftDepth = getDepth(cur.left, max1);
            int rightDepth = getDepth(cur.right, max2);
            max1[0] = 0;
            max2[0] = 0;
            if (leftDepth == rightDepth) {
                return cur;
            }
            if (leftDepth > rightDepth) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    // find the depth of cur node
    private int getDepth(TreeNode node, int[] max) {

        if (node == null) {
            return -1;
        }

        int left = getDepth(node.left, max);
        int right = getDepth(node.right, max);
        max[0] = Math.max(max[0], left + 1);
        max[0] = Math.max(max[0], right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        Integer[] input = {1,5,2,8,null,3,10,null,9,6,4,null,null,12,null,null,11,null,7,13};
        TreeNode root = treeNode.initialTree(input);
//        treeNode.printTree(root);
        LC_1123 lc_1123 = new LC_1123();
        TreeNode res = lc_1123.lcaDeepestLeaves(root);
        treeNode.printTree(res);
    }
}
