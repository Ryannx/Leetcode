### 解题思路：
本题很容易想到brute force解法，但看数据范围达到了1e5级别，那如何判断两个字符串相等就称为最主要的问题。很自然想要提前处理
字符串，希望后面只需要查询就可以得到结果，不妨对字符串进行提前预处理编码，将字符串想成26进制数，进行哈希编码。但Java并不支持
无符号长整型，所以需要进行取模处理。预处理完成，只需要用binary search来猜当前位置的最长字符串长度即可。