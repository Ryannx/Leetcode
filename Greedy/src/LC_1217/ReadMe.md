### 解题思路：
由于间隔两个位置可以0消耗的移动，并且每次只能移动一个chip，所以可以优先将所有的chips移动到两个
位置并且是0 cost，即将所有偶数位置的chip移动到位置0，所有奇数位置的chip移动到位置1，然后将
两个位置数量少的一堆chips移动到数量多的位置。