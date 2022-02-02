package LC_2096;

import Library.*;

import java.util.ArrayList;
import java.util.List;

public class LC_2096 {
    public String getDirections(TreeNode root, int startValue, int destValue) {

        List<Integer> root2startVal = new ArrayList<>();
        List<Integer> root2destVal = new ArrayList<>();
        List<Character> root2startCom = new ArrayList<>();
        List<Character> root2destCom = new ArrayList<>();
        dfs(root, startValue, root2startVal, root2startCom);
        dfs(root, destValue, root2destVal, root2destCom);
        int k = 0;
        while (k < root2startVal.size() && k < root2destVal.size()
                && root2startVal.get(k).equals(root2destVal.get(k))) {
            k++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = k; i < root2startCom.size(); i++) {
            res.append('U');
        }
        for (int i = k; i < root2destCom.size(); i++) {
            res.append(root2destCom.get(i));
        }

        return res.toString();
    }

    private boolean dfs(TreeNode node, int target, List<Integer> path, List<Character> command) {

        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        // left
        if (node.left != null) {
            path.add(node.left.val);
            command.add('L');
            if (dfs(node.left, target, path, command)) {
                return true;
            }
            path.remove(path.size() - 1);
            command.remove(command.size() - 1);
        }
        // right
        if (node.right != null) {
            path.add(node.right.val);
            command.add('R');
            if (dfs(node.right, target, path, command)) {
                return true;
            }
            path.remove(path.size() - 1);
            command.remove(command.size() - 1);
        }


        return false;
    }

    public static void main(String[] args) {
        Integer[] input = {5,1,2,3,null,6,4};
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.initialTree(input);
        LC_2096 lc_2096 = new LC_2096();
        int starVal = 3;
        int destVal = 6;
        System.out.println(lc_2096.getDirections(root, starVal, destVal));
    }
}
