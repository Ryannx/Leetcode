package LC_699;

class SegTreeNode {

    private SegTreeNode left, right;
    private int start, end;
    private int info;
    private boolean tag; // whether need to update leaves node;

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
            node.tag = true;
            node.info = val;
            return;
        }

        pushDown(node);
        updateRange(node.left, start, end, val);
        updateRange(node.right, start, end, val);
        node.info = Math.max(node.left.info, node.right.info);
    }

    private void pushDown(SegTreeNode node) {

        if (!node.tag) {
            return;
        }
        node.left.info = node.info;
        node.right.info = node.info;
        node.left.tag = true;
        node.right.tag = true;
        node.tag = false;
    }

    public int queryRange(SegTreeNode node, int start, int end) {

        if (start > node.end || end < node.start) {
            return Integer.MIN_VALUE;
        }
        if (start <= node.start && node.end <= end) {
            return node.info;
        }
        pushDown(node);
        return Math.max(queryRange(node.left, start, end), queryRange(node.right, start, end));
    }

    public int getMax(SegTreeNode node) {
        return node.info;
    }
}
