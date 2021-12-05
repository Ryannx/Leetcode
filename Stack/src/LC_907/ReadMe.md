### 解题思路：
题目要求所有subarray最小值的和，brute force的方法为直接找出所有的subarray，同时找到每个subarray
的最小值，这个方法的时间复杂度为O(n^2)；而n为10^4数量级，所以这个方法并不可行。  
我们可以换一个思路，先确定最小值，在找出有多少个subarray以这个数为最小值，即找出选定元素的
prevSmaller和nextSmaller位置，可以得出有多少个以选定值为最小值的subarray。求给定数组每个元素
的prevSmaller和nextSmaller的时间复杂度为O(n)，所以整体的时间复杂度为O(n)。这里需要注意给定
数组中有重复元素，例如：
> 2 1 3 1

当我们选择第一个1为最小值找subarray时，[2,1,3,1] [1,3,1]都是valid的结果，当我们以第二个1为
最小值为subarray是，会重复计算[2,1,3,1] [1,3,1]这两个subarray，所以我们约定，在找prevSmaller
时，在遇到第一个重复元素时就停止，即实际找的是prevSmallerOrEqual element。这样可以避免重复计算。
