package GAME.LC_486;

public class LC_486 {

    public boolean PredictTheWinner(int[] nums) {

        if (nums == null) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int inputLen = nums.length;
        int[][] memo = new int[inputLen][inputLen];
        int player1Score = dfs(nums, 0, nums.length - 1, memo);
        return player1Score >= sum - player1Score;
    }

    private int dfs(int[] nums, int i, int j, int[][] memo) {

        if (i == j) {
            return nums[i];
        }
        if (i > j) {
            return 0;
        }

        // player 1 choose left && player 2 choose right / player 1 choose left && player 2 choose left
        int p1 = Math.min(dfs(nums, i + 1, j - 1, memo), dfs(nums, i + 2, j, memo)) + nums[i];
        // player 1 choose right && player 2 choose right / player 1 choose right && player 2 choose left
        int p2 = Math.min(dfs(nums, i, j - 2, memo), dfs(nums, i + 1, j - 1, memo)) + nums[j];

        memo[i][j] = Math.max(p1, p2);
        return memo[i][j];
    }

    public static void main(String[] args) {
        LC_486 lc_486 = new LC_486();
        int[] nums = {1,5,2};
        System.out.println(lc_486.PredictTheWinner(nums));
    }
}
