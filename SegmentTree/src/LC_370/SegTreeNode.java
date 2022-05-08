package LC_370;

class SegTreeNode {

    private SegTreeNode left, right;
    private int start, end;
    private int info, tag;

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

        if (start > node.end || end < node.start) {
            return;
        }

        if (start <= node.start && node.end <= end) {
            node.tag += val;
            node.info += val * (node.end - node.start + 1);
            return;
        }

        pushDown(node);
        updateRange(node.left, start, end, val);
        updateRange(node.right, start, end, val);
        node.info = node.left.info + node.right.info;
    }

    private int queryRange(SegTreeNode node, int start, int end) {

        if (start > node.end || end < node.start) {
            return 0;
        }
        if (start <= node.start && node.end <= end) {
            return node.info;
        }

        pushDown(node);
        return queryRange(node.left, start, end) + queryRange(node.right, start, end);
    }

    public int querySingle(SegTreeNode node, int idx) {
        return queryRange(node, idx, idx);
    }

    private void pushDown(SegTreeNode node) {
        if (node.tag == 0) {
            return;
        }
        node.left.info += node.tag * (node.left.end - node.left.start + 1);
        node.left.tag += node.tag;
        node.right.info += node.tag * (node.right.end - node.right.start + 1);
        node.right.tag += node.tag;
        node.tag = 0;
    }
}
