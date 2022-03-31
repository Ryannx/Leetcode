### 解题思路：
题目：Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.  
题目要求，如能修改数组并且O(1)时间复杂度。不妨考虑binary search猜数字的方法，不妨猜数字k = (1+n)/2；我们需要统计在数组
nums中有多少个小于等于k的数字，假设有m个，因为如果小于等于k的数子中没有duplicate，那么应该正好有k个数字（数字范围是1到n），
如果m<=k，这个duplicate的数字应该是大于k，如果m>k，需要猜小一点。最终收敛于start。