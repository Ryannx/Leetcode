### 解题思路：
本题数据规模比较大，所以算法的时间复杂度锁定在O(N)或者O(NlogN)，由于切的位置都是确定的，假设先水平切，那么切出来的所有part
他们的宽度都是相同的，那么最大的part一定在高度最大只一part上，同理考虑垂直切。