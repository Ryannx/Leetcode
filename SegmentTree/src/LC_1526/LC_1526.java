package LC_1526;

public class LC_1526 {
    public int minNumberOperations(int[] target) {

        if (target == null || target.length == 0) {
            return 0;
        }

        SegTreeNode root = new SegTreeNode(0, target.length - 1);
        root.initial(root, 0, target.length - 1, target);
        return helper(root, target, 0, target.length - 1, 0);
    }

    // the num of steps from base to [start, end]'s minVal
    private int helper(SegTreeNode node, int[] target, int start, int end, int base) {

        if (start > end) {
            return 0;
        }
        if (start == end) {
            return target[start] - base;
        }
        int res = 0;
        int curMinValIdx = node.queryRange(node, start, end, target);
        res += target[curMinValIdx] - base;
        int left = helper(node, target, start, curMinValIdx - 1, target[curMinValIdx]);
        int right = helper(node, target, curMinValIdx + 1, end, target[curMinValIdx]);
        res += left + right;
        return res;
    }

    public static void main(String[] args) {
        LC_1526 lc_1526 = new LC_1526();
        int[] target = {3,1,5,4,2};
        System.out.println(lc_1526.minNumberOperations(target));
    }
}
