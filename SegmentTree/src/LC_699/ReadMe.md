### 解题思路：
于[218. The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/)思路相似，这里要求每次更新
后，区间最大值。更新时有一个小trick，我们SegmentTree的传统API是updateRange和queryRange，updateRange是将范围内info
更新，这里如果直接call updateRang，那么需要处理重合区间值的再次计算；为了方便书写，可以先call queryRange求区间的最大值，
然后将val+区间最大值作为需要更新的val进行update。这里同样需要注意两区间首尾相连时的情况。