### 解题思路：
给定数组表示直方图，求直方图中最大的矩形面积。
思路如下：用单调递增栈来进行计算，如果第i个元素大于栈顶元素，只需要进行压栈操作，反之需要将stack
中大于元素i的元素全部弹出，同时计算以每个弹出元素为高所能围出的最大面积。  
这里有一个小技巧，在完成压缩以后，在每个状态的头和尾分别插入一个0元素，并且stack中也提前压入一个0，
提前压入0是因为在连续弹栈操作时，将会用到弹栈元素的下一个元素，提前压入一个0可以防止stack为空。
在结尾出插入一个0元素，是因为我们只在弹栈的时候计算面积，而有意义的高度最小为1，这样就可以保证
stack中的所有有意义元素弹栈并计算。