### 解题思路：
本题要求所有subarray中最小值与区间和的乘积的加和。给定input有10^5级别，所以算法的时间复杂度最大不能超过O(nlogn)。不妨
通过举例来观察，看是否有什么规律。
> a X X X X i X X X b 

不妨假设i是整个subarray[a+1, b-1]中的最小值，所以a是 prev smaller element，b是next smaller
elsement(a后面会进一步解释)。那么现在的问题转化为如何能够快速求出这个subarray的区间和。一般的区间和我们很快想到可以用
presum来处理。这里还是先将例子展开观察。  
> a X X X X i X X X b  
> 0 1 2 3 4  

如果固定右边界，我们发现位于a和i之间的元素在求和时会被加的次数如上面的例子，假设y = b - i（包含i点）。那么左边区间和需要
计算y次。  
> a X X X X i X X X b  
> 0 0 0 0 0 0 3 2 1  

同理只观察i的右边，我们发现位于a和i之间的元素在求和时会被加的次数如上面的例子，假设x = i - a（包含i点）。那么右边需要计算
x次。中间的i点需要计算x*y次。进一步展开  
> nums[a+1]*1 + nums[a+2]*2 + nums[a+3]*3 + nums[a+4]*4

上面的式子很像presum，并且系数也是有规律可寻，我们不妨求一下
> presum2[i] = presum2[i-1] + nums[i]i

将本题的要求等式进行变化
> nums[a+1]*(a+1) + nums[a+2]*(a+2) + nums[a+3]*(a+3) + nums[a+4]*(a+4) =>  
> (nums[a+1]*a + nums[a+2]*a + nums[a+3]*a + nums[a+4]*a) + (nums[a+1]*1 + nums[a+2]*2 + nums[a+3]*3 + nums[a+4]*4)

通过上述变化发现我们要求的left = presum2[i-1] - presum2[a] - (presum[i-1] - presum[a]) * a。  
用相同的思路，我们来处理right。
> nums[i+1]*3 + nums[i+2]*2 + nums[i+3]*1 =>  
> nums[b-i+1]*(i-1) + nums[b-2]*2 + nums[b-1]*1  

> nums[b-3]*(b-3) + nums[b-2]*(b-2) + nums[b-1]*(b-1) =>  
> nums[b-3]*b + nums[b-2]*b + nums[b-1]*b - (nums[b-i+1]*(i-1) + nums[b-2]*2 + nums[b-1]*1)

所以right = nums[b-3]*b + nums[b-2]*b + nums[b-1]*b - (nums[b-3]*(b-3) + nums[b-2]*(b-2) + nums[b-1]*(b-1))  
这样我们就可以O(1)得到[a+1, b-1]区间内的所有subarray的区间和。
这里需要注意如果区间内有相同的最小值怎么办
> [1, 3, 4, 1, 2, 5]

这里a实际上我们计算的是prev smaller or equal，这样就可以包含所有subarray了。