### 解题思路：
dp[i]: i个数有多少种BST。在[1 : i]中任选一个k作为root, dp[i] += dp[k - 1] * dp[i - k]。