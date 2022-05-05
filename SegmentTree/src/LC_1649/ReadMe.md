### 解题思路：
本题比较容易想到divide&conquer，最需要解决的问题是在插入当前元素时，之前有多少个元素比当前元素大，多少个元素比当前元素小。
很容易想到这是一个区间query问题，可以向SegmengTree努力，但是并不能直接将input暴力输入SegTree，所以需要进行预处理，
不妨先将input进行sort并merge相同元素，再将新数组的idx输入SegTree，每个node记录当前idx出现的频次和。因为新数组有序，所以
SegTree可以非常方便query [start, idx - 1]（小于nums[idx]元素的个数）[idx + 1, end]（大于nums[idx]元素的个数）这两个
区间中有多少个元素；然后再进行单点更新即可。
