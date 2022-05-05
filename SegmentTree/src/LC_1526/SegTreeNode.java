package LC_1526;

class SegTreeNode {
    private SegTreeNode left;
    private SegTreeNode right;
    private int start, end;
    private int minValIdx;
    private int minVal;

    public SegTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.minVal = Integer.MAX_VALUE;
    }

    public void initial(SegTreeNode node, int start, int end, int[] nums) {

        if (start == end) {
            node.minVal = nums[start];
            node.minValIdx = start;
            return;
        }
        int mid = start + (end - start) / 2;
        if (node.left == null) {
            node.left = new SegTreeNode(start, mid);
            node.right = new SegTreeNode(mid + 1, end);
        }
        initial(node.left, start, mid, nums);
        initial(node.right, mid + 1, end, nums);
        if (node.right.minVal >= node.left.minVal) {
            node.minVal = node.left.minVal;
            node.minValIdx = node.left.minValIdx;
        } else {
            node.minVal = node.right.minVal;
            node.minValIdx = node.right.minValIdx;
        }
    }

    // ask [start, end] minValIdx
    public int queryRange(SegTreeNode node, int start, int end, int[] nums) {

        if (start > node.end || end < node.start) {
            return -1;
        }
        if (start <= node.start && end >= node.end) {
            return node.minValIdx;
        }

        int leftMinValIdx = queryRange(node.left, start, end, nums);
        int rightMinValIdx = queryRange(node.right, start, end, nums);
        if (leftMinValIdx == -1) {
            return rightMinValIdx;
        }
        if (rightMinValIdx == -1) {
            return leftMinValIdx;
        }
        if (nums[leftMinValIdx] < nums[rightMinValIdx]) {
            return leftMinValIdx;
        }
        return rightMinValIdx;
    }
}
