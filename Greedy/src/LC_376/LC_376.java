package LC_376;

public class LC_376 {
    public int wiggleMaxLength(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 1;
        int dir = -2;
        for (int i = 1; i < nums.length; i++) {
            int prevDir = dir;
            if (nums[i] - nums[i - 1] > 0) {
                dir = 1;
            } else if (nums[i] - nums[i - 1] < 0) {
                dir = -1;
            } else {
                dir = prevDir;
            }

            if (dir != prevDir) {
                res++;
            }
        }

        return res;
    }
}
