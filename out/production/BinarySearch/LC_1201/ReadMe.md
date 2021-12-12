### 解题思路：
猜数字，不妨假设在[1, Integer.MAX_VALUE]之间猜一个数字M，如果M前面ugly number数量小于n，需要猜一个更大的M，如果M前面
ugly number数量大于等于n，我们要猜一个更小的M，问题变为如何快速求M有多少个ugly number，用到互斥原理：
> 已知a, b, c, M，求小于等于M的数，有多少个可以被a或b或c整除。  
> M / a + M / b + M / c - M / lcm(a, b) - M / lcm(a, c) - M / lcm(b, c) + M / lcm(lcm(a, b), c)  
> lcm为最小公倍数

