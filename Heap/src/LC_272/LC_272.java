package LC_272;

import java.util.*;

public class LC_272 {

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

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        if (root == null) {
            return null;
        }

        Comparator<Integer> comparator = (a, b) -> (b - a);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        initializeHeaps(root, maxHeap, minHeap, target);

        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (target - (double) maxHeap.peek() < (double) minHeap.peek() - target) {
                    res.add(maxHeap.poll());
                } else {
                    res.add(minHeap.poll());
                }
            } else if (!maxHeap.isEmpty()) {
                res.add(maxHeap.poll());
            } else if (!minHeap.isEmpty()) {
                res.add(minHeap.poll());
            }
        }

        return res;
    }

    private void initializeHeaps(TreeNode node, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, double target) {

        if (node == null) {
            return;
        }

        if (Double.compare(node.val, target) < 0) {
            maxHeap.add(node.val);
        } else {
            minHeap.add(node.val);
        }
        initializeHeaps(node.left, maxHeap, minHeap, target);
        initializeHeaps(node.right, maxHeap, minHeap, target);
    }

    public static void main(String[] args) {
        LC_272 lc_272 = new LC_272();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(lc_272.closestKValues(root, 3.714286, 2));
    }
}
