package LC_297;

import Library.*;

public class LC_297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder path = new StringBuilder();
        dfsSerialize(root, path);
        path.setLength(path.length() - 1);
        return path.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder path) {

        if (node == null) {
            path.append("#").append(",");
            return;
        }

        path.append(node.val).append(",");
        dfsSerialize(node.left, path);
        dfsSerialize(node.right, path);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0) {
            return null;
        }

        String[] nodes = data.split(",");
        int[] idx = new int[1];
        return dfsDeserialize(nodes, idx);
    }

    private TreeNode dfsDeserialize(String[] nodes, int[] idx) {

        int len = nodes.length;
        if (idx[0] == len || nodes[idx[0]].equals("#")) {
            return null;
        }

        int val = Integer.parseInt(nodes[idx[0]]);
        TreeNode root = new TreeNode(val);
        idx[0]++;
        root.left = dfsDeserialize(nodes, idx);
        idx[0]++;
        root.right = dfsDeserialize(nodes, idx);
        return root;
    }

    public static void main(String[] args) {
        LC_297 lc_297 = new LC_297();
        String input = "1,2,#,#,3,4,#,#,5,#,#";
        lc_297.deserialize(input);
    }
}
