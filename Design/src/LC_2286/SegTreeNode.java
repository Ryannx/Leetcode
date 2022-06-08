package LC_2286;

class SegTreeNode {
    private SegTreeNode left, right;
    private long validSeats; // 有多少valid seats
    private int maxValidSeats; // 一行中剩余最多连续seats数量
    private int start, end;

    public SegTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void initial(SegTreeNode node, int start, int end, int info) {

        if (start == end) {
            node.validSeats = info;
            node.maxValidSeats = info;
            return;
        }
        int mid = start + (end - start) / 2;
        if (node.left == null) {
            node.left = new SegTreeNode(start, mid);
            node.right = new SegTreeNode(mid + 1, end);
        }
        initial(node.left, start, mid, info);
        initial(node.right, mid + 1, end, info);
        node.validSeats = node.left.validSeats + node.right.validSeats;
        node.maxValidSeats = Math.max(node.left.maxValidSeats, node.right.maxValidSeats);
    }

    // 这里只用做单点更新
    public void updateRange(SegTreeNode node, int start, int end, int info) {

        if (end < node.start || start > node.end) {
            return;
        }
        if (start <= node.start && node.end <= end) {
            node.validSeats = info;
            node.maxValidSeats = info;
            return;
        }

        updateRange(node.left, start, end, info);
        updateRange(node.right, start, end, info);
        node.validSeats = node.left.validSeats + node.right.validSeats;
        node.maxValidSeats = Math.max(node.left.maxValidSeats, node.right.maxValidSeats);
    }

    public long queryRangeSum(SegTreeNode node, int start, int end) {

        if (end < node.start || start > node.end) {
            return 0;
        }
        if (start <= node.start && node.end <= end) {
            return node.validSeats;
        }

        long l = queryRangeSum(node.left, start, end);
        long r = queryRangeSum(node.right, start, end);
        return l + r;
    }

    public int queryRangeMax(SegTreeNode node, int start, int end) {

        if (start > node.end || end < node.start) {
            return 0;
        }
        if (start <= node.start && node.end <= end) {
            return node.maxValidSeats;
        }

        return Math.max(queryRangeMax(node.left, start, end), queryRangeMax(node.right, start, end));
    }
}
