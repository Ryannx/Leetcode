### 解题思路：
本题要求频繁的区间更新和总数字和，但是发现区间的范围非常大，达到1e9级别，并且不能确定一共有多少点需要处理，所以也不能使用
离散化技巧，SegmentTree不可行。此外用sweeping line方法操作，由于数据规模太大，最后两个例子TLE（应该是每次需要排序造成）。
因此需要找到一种自动排序数据结构来记录这些Interval，TreeMap可以使用。用TreeMap来记录interval最大问题是如何将overlap
的interval进行merge，这里有一个非常不错的技巧，只需重复下面几步即可完成：
> 假设更行[left, right];  merge之后的interval[start, end]; start = left, end = right;
1. 找比end小的最大值(floorKey)，check这个interval是否与[start, end]有overlap
2. start = min(start, floorKey); end = max(end, floorVal)；删除overlap的interval，更新count
3. 重复1和2，直到找不到floorKey或者floorVal < start，完成merge，更新新interval和count，结束loop。