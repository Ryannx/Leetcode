### 解题思路：
如图：![两种topologic](https://github.com/Ryannx/git-photo/blob/6b2456bf543d2c690988d1a696e0c5a410920de4/LC2127.jpeg "两种topologic")
通过举例分析可以看出，只有如图的两种情况，即左图在环中的所有人可以参与会议；右图由两个Vertex组成的环，以及环中两点组成的最长
的链的人可以参与会议。同时需要注意，图中左右两种情况并不能一起组成一个大环；但是二元环的情况是可以不断拼接在一起的。  
由以上特点我们可以确定使用bfs剥洋葱算法，去除掉不是环中的点，同时为二元环的点标记上深度（方便找到最长的链）；然后遍历所有环
上的点，确定环的类型；环中点的个数大于2个，只需要选出最大的环即可；对二元环而言，我们需要找到每一个二元环以及包含端点最长链的
长度，并对所有最大长度求和。  
同时注意，在对深度进行更新时，点会自动更新到最大深度。