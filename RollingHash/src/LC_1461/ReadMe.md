### 解题思路：
本题处理超长string，并且不断截取substring，很容易想到rolling hash的方法。最值得注意的技巧是，如何快速截取k长度的bitmask。