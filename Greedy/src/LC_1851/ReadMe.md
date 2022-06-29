### 解题思路：
本题的queries为给定input，所以应该考虑如何优化queries
> intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]

假设如果interval满足left <= 2，如果queries是从小到大排序，那么这个left也一定满足后面的要求；剩下需要考虑的就是duration
和right的问题，本题要求min duration，同时right >= 2，不妨将满足left的interval，放入minHeap中，minHeap按照duration
从小到大排序，这样就可以按照顺序检测right是否满足要求。