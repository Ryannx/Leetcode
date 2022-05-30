### 解题思路：
常规Dijkstr，这里记录的是从起点到当前位置需要remove Obstacle的个数。这里注意虽然只维护一个visited数组，只在出minHeap
时更新，逻辑上没有问题。但是效率并不好，应该将boolean visited变成，int visited 记录到当前位置所需的最小消耗，在进行入队
操作时，如果已经比visited记录的val大就不需要入队了，这样有一定程度的优化效果。