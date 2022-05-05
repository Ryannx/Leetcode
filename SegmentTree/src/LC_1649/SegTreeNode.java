package LC_1649;

class SegTreeNode {

    private SegTreeNode left, right;
    private int amount;
    private int start, end;

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
        node.amount = node.left.amount + node.right.amount;
    }

    public void singleUpdate(SegTreeNode node, int idx, int val) {

        if (idx < node.start || idx > node.end) {
            return;
        }
        if (node.start == node.end) {
            node.amount += val;
            return;
        }

        singleUpdate(node.left, idx, val);
        singleUpdate(node.right, idx, val);
        node.amount = node.left.amount + node.right.amount;
    }

    public int queryRange(SegTreeNode node, int start, int end) {

        if (end < node.start || start > node.end) {
            return 0;
        }
        if (start <= node.start && node.end <= end) {
            return node.amount;
        }

        return queryRange(node.left, start, end) + queryRange(node.right, start, end);
    }
}
