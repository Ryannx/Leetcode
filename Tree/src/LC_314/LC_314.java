package LC_314;

import java.util.*;
import Library.*;

public class LC_314 {

    private static class Cell {
        private TreeNode node;
        private int col;
        public Cell(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(col);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj instanceof Cell) {
                Cell another = (Cell) obj;
                return another.col == this.col && another.node.val == this.node.val;
            }

            return false;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode node) {

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(node, 0));
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, List<Integer>> col2Vals = new TreeMap<>();
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            List<Integer> val = col2Vals.getOrDefault(cur.col, new ArrayList<>());
            val.add(cur.node.val);
            col2Vals.put(cur.col, val);
            if (cur.node.left != null) {
                queue.add(new Cell(cur.node.left, cur.col - 1));
            }
            if (cur.node.right != null) {
                queue.add(new Cell(cur.node.right, cur.col + 1));
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : col2Vals.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    public static void main(String[] args) {
        LC_314 lc_314 = new LC_314();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(lc_314.verticalOrder(root));
    }
}
