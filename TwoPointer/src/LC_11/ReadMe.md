### 解题思路：
本题求最大长方形面积，长方形面积 = 长 * 宽；所以我们要找到，长设为两个坐标之间的距离，宽为左右选定边界中高度较小值，
不妨用双指针模仿这个过程，双指针相向而行。