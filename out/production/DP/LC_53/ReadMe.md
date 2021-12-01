### 解题思路：
本题要求的是subarray，是连续截取，所以在每个idx位置会面对选和不选两种情况，可以定义dp[i]为
以i结尾的subarray最大值，dp[i]只与dp[i - 1]有关。
dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);