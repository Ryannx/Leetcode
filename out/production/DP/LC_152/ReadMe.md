### 解题思路：
本题思路跟[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
类似，53题只分为两种情况：
1. subarray长度为1，nums[i]自己组成新的subarray
2. subarray长度大于1，dp[i - 1] + nums[i]是新subarray的最大和。

本题也是分为这两种情况，但是由于需要处理的是乘积，并且nums[i]正负并不确定，所以需要根据nums[i]
的正负来分开讨论：
1. nums[i] > 0，需要找一个最大的dp[i - 1]，并在dp[i - 1] * nums[i]和nums[i]中找最大值。
2. nums[i] < 0，需要找一个最小的dp[i - 1]，并在dp[i - 1] * nums[i]和nums[i]中找最大值。

因此，需要更新dp1记录以i结尾的最大乘积，和dp2记录以i结尾的最小乘积。由于最大值和最小值只会在
dp1[i - 1] * nums[i], dp2[i - 1] * nums[i], nums[i]三者中出现，所以只需要在这三者中
无脑找最大值和最小值即可。