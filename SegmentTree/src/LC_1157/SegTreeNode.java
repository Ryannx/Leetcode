package LC_1157;

class SegTreeNode {

    private SegTreeNode left, right;
    private int start, end;
    private int val, diff;

    public SegTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void initial(SegTreeNode node, int start, int end, int[] nums) {

        if (start == end) {
            node.val = nums[start];
            node.diff = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        if (node.left == null) {
            node.left = new SegTreeNode(start, mid);
            node.right = new SegTreeNode(mid + 1, end);
        }
        initial(node.left, start, mid, nums);
        initial(node.right, mid + 1, end, nums);
        if (node.left.val == node.right.val) {
            node.val = node.left.val;
            node.diff = node.left.diff + node.right.diff;
        } else if (node.left.diff >= node.right.diff) {
            node.val = node.left.val;
            node.diff = node.left.diff - node.right.diff;
        } else {
            node.val = node.right.val;
            node.diff = node.right.diff - node.left.diff;
        }
    }

    public int[] queryRange(SegTreeNode node, int start, int end) {

        // [val, diff]
        if (start > node.end || end < node.start) {
            return new int[] {-1, -1};
        }
        if (start <= node.start && node.end <= end) {
            return new int[] {node.val, node.diff};
        }

        int[] left = queryRange(node.left, start, end);
        int[] right = queryRange(node.right, start, end);
        if (left[0] == -1) {
            return right;
        }
        if (right[0] == -1) {
            return left;
        }
        if (left[0] == right[0]) {
            return new int[] {left[0], left[1] + right[1]};
        }
        if (left[1] >= right[1]) {
            return new int[] {left[0], left[1] - right[1]};
        }
        return new int[] {right[0], right[1] - left[1]};
    }
}
