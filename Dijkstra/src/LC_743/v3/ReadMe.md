### 解题思路：
Floyd算法，可以处理边权值为负的情况，具体思路为，求一个二维数组，dp[i][j]的含义为从i到j的最短距离，我们每放出一个m点，
更新所有的从i到m再从m到j的最短距离，即dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m][j])。最后从k出发的点中选择
除Integer.MAX_VALUE/2 的最大距离，如果最大距离为Integer.MAX_VALUE/2，说明从k出发不能到达所有的点。