### 解题思路：
brute force解法，可以考虑先将所有的元素和元素出现的位置记录下来，然后将从出现频次最高的元素开始进行check是否满足要求。
那么是否可以缩小需要进行check的candidate的范围呢？本题也是要求queryRange，所以很容易想到SegmentTree。在区间范围内求
majority是O(n)的，但是我们可以参考投票算法，记录小区间的majority和这个majority与其他少数元素频次的差值；利用两个信息
可以判断出大区间最有可能成为majority的元素，这样每次判断的消耗位O(1)。具体分为一下3中情况：
1. > [1,1,1,2,2] & [1,1,1,1,4] 分别位区间a和b。a[1, 1] b[1,3]  
   > a b区间majority相同，所以合并后的大区间majority一定是之前的majority=1  
   > 大区间c更新后为c[1, 4]。
2. > [1,1,1,1,2] & [2,2,2,3,4] 分别位区间a和b。a[1, 3] b[2,1]
   > a b区间majority不同，我们可以选diff大的majority最为整个大区间majority的candidate，因为通过观察可以发现大区间c
   > 的majority一定是两个小区间的majority中产生，a b区间的majority不一定是合格的c区间的majority。这时大区间c更新
   > 为c[1,2]。虽然通过观察知道这个答案并不准确，但是1仍然是最有可能的candidate之一。
3. > [1,1,1,2,2] & [3,3,3,4,4] 同2，大区间c只需要选1或者3作为majority即可，diff更新为0。

所以在query完之后，我们只需要再check这个最有可能的candidate是否满足要求即可。