### 解题思路：
dp[i]:以i为结尾最长valid括号有多长。s[i] == '('时，不可能满足条件所以为0；s[i] == ')'时，如若s[i-1] == '('那么
dp[i] = dp[i-2]+2;否则需要找到之前满足条件idx = i - dp[i - 1] - 1，dp[i] = i - idx + 1 + dp[idx - 1])。