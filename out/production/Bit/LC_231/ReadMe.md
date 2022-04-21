### 解题思路：
通过观察2pow的数的二进制表示，可以发现， 该数是由一个1和若干个0表示而成；如果将该数取反加一，得到该数的
负数；将两数取 & 发现又得到当前的数。同理可以观察不是2pow的数，经过相同操作，并不能得到本身。
[Leetcode讲解](https://leetcode.com/problems/power-of-two/solution/)