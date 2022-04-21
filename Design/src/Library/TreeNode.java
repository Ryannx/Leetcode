package Library;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode initialTree(Integer[] input) {

        Queue<TreeNode> queue = new LinkedList<>();
        int idx = 1;
        TreeNode root = new TreeNode(input[0]);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                continue;
            }
            if (idx < input.length && input[idx] != null) {
                cur.left = new TreeNode(input[idx]);
                queue.add(cur.left);
            } else {
                queue.add(null);
            }
            if (idx + 1 < input.length && input[idx + 1] != null) {
                cur.right = new TreeNode(input[idx + 1]);
                queue.add(cur.right);
            } else {
                queue.add(null);
            }
            idx += 2;
        }

        return root;
    }

    public void printTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                res.add(null);
            } else {
                res.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        Integer[] input = {1,5,2,8,null,3,10,null,9,6,4,null,null,12};
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.initialTree(input);
        treeNode.printTree(root);
    }
}
