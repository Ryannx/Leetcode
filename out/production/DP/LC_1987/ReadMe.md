### 解题思路：
承接[940. Distinct Subsequences II](https://leetcode.com/problems/distinct-subsequences-ii/)思路，本题加上
unique和good两个条件，那么如何去重呢？我们需要找与binary[i]最近的相同元素，设该位置为j，dp[i] = dp[i-1] * 2 - dp[j-1];
重复部分为选取j位置元素所有的unique subsequence个数；如何保证good呢？这里good定义为非空，非0开头的除0意外数字；这里
就涉及到对dp的理解，我们找到binary中第一个1的位置，在这个位置开始我们的dp计算，并且此位置的dp[i] = 1（排除了空的情况），
那么从这个位置之后计算出来的所有值都保证了good条件。