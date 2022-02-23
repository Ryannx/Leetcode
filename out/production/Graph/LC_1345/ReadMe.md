### 解题思路：
最短距离BFS，tricky的地方在于[0, n]中[0, n-1]元素全部相同，如果按照常规BFS思路，相同val的idxSet也需要一次检查visited；
这样会TLE，不妨在相同val的idx入队以后，直接删除这个valSet。这样遇到之前处理过的元素只需要检查是否valSet是否为null即可。