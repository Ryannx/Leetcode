### 解题思路：
convert string，不妨设dp[i][j]:str1[0:i] str2[0:j]相等需要最少删除几步。str1[i] == str2[j] dp[i][j] = dp[i-1][j-1]
else dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j-1]+1)