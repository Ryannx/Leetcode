### 解题思路：
与 [505. The Maze II](https://leetcode.com/problems/the-maze-ii/) 相同思路，增加了记录路径，并且按照字母序比较
路径大小的需求，所以需要一个自定class完成记录【distance, path, i, j]，同时implement Comparable接口。