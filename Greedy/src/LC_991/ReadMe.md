### 解题思路：
题目中只有两种操作 *2 和 -1，通过给的例子可以感觉出，应该跟target的奇偶性有关。题目要求最少的操作步数，乘法的效率明显比
减法高，所以最后一步操作应该是乘法，在target是偶数的情况下。如果target是奇数，那么最后一步一定是减法。由此可得递归关系。