package LC_652;

import Library.TreeNode;
import java.util.*;

public class LC_652 {

    private HashMap<String, Integer> key2id;
    private HashMap<Integer, Integer> id2count;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        key2id = new HashMap<>();
        id2count = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        getId(root, res);
        return res;
    }

    private int getId(TreeNode node, List<TreeNode> res) {

        if (node == null) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append("#");
        sb.append(getId(node.left, res)).append("#");
        sb.append(getId(node.right, res));
        String key = sb.toString();
        Integer id = key2id.get(key);
        if (id == null) {
            key2id.put(key, key2id.size());
            id2count.put(key2id.size() - 1, 1);
        } else {
            int count = id2count.get(id);
            id2count.put(id, count + 1);
            if (count + 1 == 2) {
                res.add(node);
            }
        }

        return key2id.get(key);
    }

    public static void main(String[] args) {
        LC_652 lc_652 = new LC_652();
        TreeNode root = new TreeNode();
        Integer[] input = {1,2,3,4,null,2,4,null,null,4};
        root = root.initialTree(input);
        lc_652.findDuplicateSubtrees(root);
    }
}
