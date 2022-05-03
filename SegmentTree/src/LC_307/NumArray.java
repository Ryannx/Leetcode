package LC_307;

public class NumArray {
    private SegTreeNode root;
    public NumArray(int[] nums) {
        this.root = new SegTreeNode(0, nums.length - 1);
        this.root.initial(root, 0, nums.length - 1, nums);
    }

    public void update(int index, int val) {
        this.root.updateSingle(root, index, val);
    }

    public int sumRange(int left, int right) {
        return this.root.queryRange(root, left, right);
    }

    public static void main(String[] args) {
        int[] nums = {0,9,5,7,3};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(1, 2));
    }
}
