### 解题思路：
打印从startNode到destNode的路径，通过观察这两个node的位置可以发现一共有两种情况，这两个node之间存在拐点或者这两个node
是链表的情况，所以题目可以转化为找两个node的最近公共祖先节点。这里可以用比较暴力的办法，分别在tree中找这两个node并且记录
下路径，然后通过对比路径找到最近公共结点。再还原路径。