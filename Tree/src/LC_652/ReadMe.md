### 解题思路：
根据题意得，需要判断每个结点与剩余结点是否为相同的tree，假设有n个结点，那么时间复杂度为O(n^2)。而n可以取到10^4，说明直接
这么做不可行。如果将tree视为一个二维结构，那么绛维可能能将问题简化，不妨通过tree的serialize来表示一个tree，这样如果两个
serialize字符串相等，说明两个tree相等。可以通过构建一个[serializeKey, count]的pair来记录每个serialize字符串出现的
数量。  

注意：在写serialize函数时，我们可以发现serialize的字符串会非常长，并且会多次计算哈希值，这样严重影响效率，不妨建立一个
[serializeKey, id] [id, count] 这样对应的一组表，可以保证每个serialize的字符串只计算一次哈希值，提高效率。