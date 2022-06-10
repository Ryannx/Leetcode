### 解题思路：
![example](https://github.com/Ryannx/git-photo/blob/959591921cda2bfd1f82776cab151144054c2f13/1526.jpg)  
如图所示：  
为了用最少的步数得到target，我们希望每次操作的subarray范围尽量大，所以可以在[start, end]范围内找到最小值的坐标i，首先
计算一下从当前base到i的steps，其次计算[start, i - 1]和[i + 1, end]范围内的答案，最终将三部分答案相加，即为所求。所以
如何快速查抄区间内的最小值成为核心问题，所以这里引用SegmentTre。