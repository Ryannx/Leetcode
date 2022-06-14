### 解题思路：
本题通过时间复杂度和input是sorted强烈暗示binary search，m = nums1.length(); n = nums2.length();通过观察发现
如果m+n是奇数，只需要找到一个数字即可；如果是偶数那么需要找到第一个数字右边的第一个元素。