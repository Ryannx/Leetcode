### 解题思路：
要把所有的1都放在一起，要求swap最少的步数，设1的数量为oneAmount，需要维护一个oneAmount大小的subarray，找到subarray中
1数量最多的那个，剩余0的数量即为所求。