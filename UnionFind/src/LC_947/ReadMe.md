### 解题思路：
本题根据题意画图尝试，发现可以将所有的stone以横坐标或者纵坐标相同进行链接，形成一个graph，在一个graph中所有的stone都可以被
删除到只剩下一个石头，所以本题变成如何将所有的石头进行链接，并判断有多少个connect component，UnionFind是最高效的方法。