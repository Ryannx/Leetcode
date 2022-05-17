### 解题思路：
本题与常规Dijkstra最大不同是对于到达终点的step有要求，可能会出现到达终点cost最小但是step超出要求的情况。所以在记录visited
时，需要同时记录当前点的位置和到达该位置所用的step，再结合Dijkstra的最大特点：第一次出minHeap以后，到达当前状态的cost一定
最小，所以结合"位置""step""cost"这三个状态可以唯一确定一条路径，这样可以准确表达visited。