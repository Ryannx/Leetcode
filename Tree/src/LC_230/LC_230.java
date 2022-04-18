package LC_230;

import Library.TreeNode;

public class LC_230 {
    public int kthSmallest(TreeNode root, int k) {

        int start = 0;
        int end = (int) 1e4;
        while (start <= end) {
            int mid = start + (end - start) / 2;
//            int temp = countNode(root, mid);
            if (countNode(root, mid) < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    private int countNode(TreeNode node, int mid) {

        if (node == null) {
            return 0;
        }

        int res = 0;
        int left = countNode(node.left, mid);
        if (node.val == mid) {
            res += left + 1;
            return res;
        }
        if (node.val < mid) {
            res += 1;
        }
        int right = countNode(node.right, mid);
        return res + left + right;
    }

    public static void main(String[] args) {
        LC_230 lc_230 = new LC_230();
        TreeNode root = new TreeNode();
        Integer[] input = {1};
        root = root.initialTree(input);
        System.out.println(lc_230.kthSmallest(root, 1));
    }
}
