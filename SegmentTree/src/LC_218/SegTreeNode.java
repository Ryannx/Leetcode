package LC_218;

import java.util.Arrays;
import java.util.List;

class SegTreeNode {
    private SegTreeNode left, right;
    private int start, end, info;
    private boolean tag; // whether [start, end] have same maxVal;

    public SegTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void initial(SegTreeNode node, int start, int end) {

        if (start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        if (node.left == null) {
            node.left = new SegTreeNode(start, mid);
            node.right = new SegTreeNode(mid + 1, end);
        }
        initial(node.left, start, mid);
        initial(node.right, mid + 1, end);
    }

    public void updateRange(SegTreeNode node, int start, int end, int val) {

        if (end < node.start || start > node.end) {
            return;
        }

        if (start <= node.start && node.end <= end && val > node.info) {
            node.info = val;
            node.tag = true;
            return;
        }
        if (node.start == node.end) {
            node.info = Math.max(node.info, val);
            node.tag = true;
            return;
        }
        pushDown(node);
        updateRange(node.left, start, end, val);
        updateRange(node.right, start, end, val);
        node.info = Math.max(node.info, Math.max(node.left.info, node.right.info));
    }

    private void pushDown(SegTreeNode node) {

        if (!node.tag) {
            return;
        }
        node.tag = false;
        node.left.tag = true;
        node.right.tag = true;
        node.left.info = node.info;
        node.right.info = node.info;
    }

    public void getAllSegment(SegTreeNode node, List<List<Integer>> candidates) {
        if (node.tag || node.start == node.end) {
            candidates.add(Arrays.asList(node.start, node.info));
            return;
        }
        getAllSegment(node.left, candidates);
        getAllSegment(node.right, candidates);
    }
}
