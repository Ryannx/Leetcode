### 解题思路：
除法本质是效率更优的减法，所以本题可以用减法来代替，但是一个除数一个除数的减效率很低，如何一次能减去多个除数又不用乘法呢？
位运算便是选择，每次将除数左移1位相当于除数乘2，这样记录一共减去多少个除数和即可。