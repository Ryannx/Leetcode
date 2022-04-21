package LC_173;

import Library.*;
import java.util.*;
public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        stack = new Stack<>();
        pushStack(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null)
            pushStack(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushStack(TreeNode node) {

        TreeNode cur = node;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}
