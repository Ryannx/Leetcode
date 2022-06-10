package FlipBinaryString;

class SegTreeNode {
    private SegTreeNode left, right;
    private int zeroIdx; // leftmost zero and one idx
    private int start, end;
    private int oneAmount;
    private char aChar;

    public SegTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void initial(SegTreeNode node, int start, int end, String str) {

        if (start == end) {
            node.zeroIdx = str.charAt(start) == '0' ? start : Integer.MAX_VALUE;
            node.oneAmount += str.charAt(start) == '1' ? 1 : 0;
            node.aChar = str.charAt(start);
            return;
        }

        int mid = start + (end - start) / 2;
        if (node.left == null) {
            node.left = new SegTreeNode(start, mid);
            node.right = new SegTreeNode(mid + 1, end);
        }

        initial(node.left, start, mid, str);
        initial(node.right, mid + 1, end, str);
        node.zeroIdx = Math.min(node.left.zeroIdx, node.right.zeroIdx);
        node.oneAmount = node.left.oneAmount + node.right.oneAmount;
    }


    public void updateRange(SegTreeNode node, int start, int end) {

        if (start > node.end || end < node.start) {
            return;
        }

        if (start <= node.start && node.end <= end) {
            if (node.aChar == '0') {
                node.zeroIdx = Integer.MAX_VALUE;
                node.oneAmount = 1;
                node.aChar = '1';
            } else {
                node.zeroIdx = start;
                node.oneAmount = 0;
                node.aChar = '0';
            }
            return;
        }

        updateRange(node.left, start, end);
        updateRange(node.right, start, end);
        node.zeroIdx = Math.min(node.left.zeroIdx, node.right.zeroIdx);
        node.oneAmount = node.left.oneAmount + node.right.oneAmount;
    }

    public int getOneAmount() {
        return oneAmount;
    }

    public int getZeroIdx() {
        return zeroIdx;
    }
}
