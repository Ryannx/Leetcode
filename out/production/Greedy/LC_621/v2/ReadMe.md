### 解题思路：
> A B C E X  
> A B C X X  
> A B D X X  
> A B

如上例：n = 4，所以为了尽可能避免idle，每一组任务的长度为5，不妨将频次出现最多元素，放在每行第一个位置，最后一行只放与最大
频次相同的元素。然后一次安排剩余元素，不足的位置用idle补齐。整个matrix的size就是ans  

> A B C D F I  
> A B C E G J  
> A B D E H  
> A B

在这种情况下，本应该用idle补齐的位置被元素替代，并且还有多余的元素填充到每一行后面，这时答案就是tasks的length，并不需要
idle补齐。