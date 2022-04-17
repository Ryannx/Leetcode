package LC_538.v1;

import Library.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_538 {
    public TreeNode convertBST(TreeNode root) {

        // inorder traverse
        List<Integer> path = new ArrayList<>();
        inorderTraverse(root, path);
        if (path.size() == 0) return root;

        // preSum
        int[] preSum = new int[path.size()];
        preSum[0] = path.get(0);
        for (int i = 1; i < path.size(); i++) {
            preSum[i] = preSum[i - 1] + path.get(i);
        }

        updateTree(root, preSum, path);
        return root;
    }

    private void updateTree(TreeNode node, int[] preSum, List<Integer> path) {

        if (node == null) {
            return;
        }

        int newVal = getVal(node.val, preSum, path);
        node.val = newVal;
        updateTree(node.left, preSum, path);
        updateTree(node.right, preSum, path);
    }

    private int getVal(int target, int[] preSum, List<Integer> path) {

        int idx = Collections.binarySearch(path, target);
        if (idx == 0) return preSum[preSum.length - 1];
        return preSum[preSum.length - 1] - preSum[idx - 1];
    }

    private void inorderTraverse(TreeNode node, List<Integer> path) {

        if (node == null) {
            return;
        }

        inorderTraverse(node.left, path);
        path.add(node.val);
        inorderTraverse(node.right, path);
    }
}
