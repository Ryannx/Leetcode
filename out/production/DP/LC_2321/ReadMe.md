### 解题思路：
先假设一个新的array temp，表示nums2 - nums1。在temp数组中找到最大subarray的和，并且这个subarray的和要非，假设这个和为
sum1；有了这个和就可以知道假设nums1是交换以后最终答案为sum(nums1)+sum1。同理假设nums2为最终修改返回的数组，在这两个
结果中取最大值。