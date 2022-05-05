package LC_307;

class SegTreeNode {

    private SegTreeNode left;
    private SegTreeNode right;
    private int info;
    private int start, end;

    public SegTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void initial(SegTreeNode node, int start, int end, int[] nums) {

        if (start == end) {
            node.info = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        if (node.left == null) {
            node.left = new SegTreeNode(start, mid);
            node.right = new SegTreeNode(mid + 1, end);
        }
        initial(node.left, start, mid, nums);
        initial(node.right, mid + 1, end, nums);
        node.info = node.left.info + node.right.info;
    }

    public void updateSingle(SegTreeNode node, int idx, int info) {

        if (idx < node.start || idx > node.end) {
            return;
        }
        if (node.start == node.end) {
            node.info = info;
            return;
        }

        updateSingle(node.left, idx, info);
        updateSingle(node.right, idx, info);
        node.info = node.left.info + node.right.info;
    }

    public int queryRange(SegTreeNode node, int start, int end) {

        if (start > node.end || end < node.start) {
            return 0;
        }
        if (node.start >= start && node.end <= end) {
            return node.info;
        }
        return queryRange(node.left, start, end) + queryRange(node.right, start, end);
    }
}
