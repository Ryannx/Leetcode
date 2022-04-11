### 解题思路：
本题如果直接按题意写，会出现TLE，然后再仔细读数据范围，发现dictionary size最大只有100，不妨直接对dictionary进行encrypt
操作，然后再来查对应的input有多少个。因为正向做会出现很多分叉，数据规模远大于dictionary。