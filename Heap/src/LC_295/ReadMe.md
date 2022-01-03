### 解题思路：
data的大小未知，并且需要ordered的顺序，所以考虑用有序容器来存储input，由于需要找median，不妨考虑将input分成两份，一个
容器装较大的一半，一个装较小的一半。同时不需要全局有序，所以考虑用heap来操作。  
follow up：由于num的数量是固定，不妨用bucket sort 和 binary search来找median。这样可以优化空间复杂度。