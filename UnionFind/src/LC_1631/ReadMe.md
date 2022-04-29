### 解题思路：
本题两个思路：
1. BinarySearch 猜一个最小cost可以联通左上和右下。
2. 计算出所有相连两点之间的cost，将这些cost从小到大排序，用UnionFind来检测左上和右下是否联通。