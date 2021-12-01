### 解题思路：
对于考察矩形的题，首先应该尽可能的将二维问题简化为一维问题，我们可以考虑在x或者y方向将矩阵压扁，
在一维数组中一个subarray可以表示一个矩形的和，经过简化以后题目变成求满足
presum[i] - presum[j] <= k, presum[i] - presum[j]的最大值，进一步转化为
presum[j] >= presum[i] - k条件下，presum[j]的最小值，如果使用有序容器查找presum[j]，
时间复杂度可以为O(logn)，n为投影方向的长度，所以在选择投影方向时，选择往 row 和 col中大的方向
投影。
