### 解题思路：
首先尝试用SegmentTree处理，记录区间内有多少长度被使用，但是离散化处理后目前不能处理两个子node合并。仔细观察跟常规sweep line
题目有所不同，这里每个结点我们需要记录paint该节点的idx（即第几天paint），之后按照[218. The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/)
的思路，需要用有序容器记录依次扫点的过程，容器按照idx来排序，表示处理idx最小天。