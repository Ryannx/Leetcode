### 解题思路：
典型的dp思路dp[i] = dp[j] + 1，最大特点是用HashMap来代替int[]，可以更方便查询满足条件的substring。