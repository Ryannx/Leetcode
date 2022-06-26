package LC_665;

public class LC_665 {
    public boolean checkPossibility(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }

        boolean flag = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (flag) return false;
                flag = true;
                if (i - 2 < 0) {
                    nums[i - 1] = nums[i];
                    continue;
                }
                if (nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LC_665 lc_665 = new LC_665();
        int[] nums = {4,2,3};
        System.out.println(lc_665.checkPossibility(nums));
    }
}
