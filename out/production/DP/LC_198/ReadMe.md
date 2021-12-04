### 解题思路：
dp[i]:第i天结束以后，所能得到的max point是多少。
dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);