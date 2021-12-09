### 解题思路：
word长度不超过15，每个位置的char都有keep和abbr两种选择，我们不妨用1表示keep，0表示abbr，
一共有2^n种abbr，n为word.length;