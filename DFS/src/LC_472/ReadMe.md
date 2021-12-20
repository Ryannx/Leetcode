### 解题思路：
本题与[140. Word Break II](https://leetcode.com/problems/word-break-ii/) 相同的思路，但是可以对word中元素
根据长度进行从小到大排序，这样在处理word时，每次搜索只会查找长度小于等于word的candidates，然后再将word加入到Trie中，
可以提高效率。