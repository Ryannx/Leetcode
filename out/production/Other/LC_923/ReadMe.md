### 解题思路：
本题最tricky的地方是要求组合按照i<j<k的顺序排列，开始一位数组arr并不能排序，否则会打乱顺序。但是仔细想会发现这个条件没用，
因为如果arr[i]+arr[j]+arr[k] == target，存在这样的(i, j, k)，排序过后这个组合依然存在，虽然(i,j,k)具体数字发生了变化
，但是满足条件的组合数量是不变的，所以不妨对arr进行sort（题目中给的例子已经暗示sort）。经过分析，(i,j,k)之间的关系可以分为
四种情况(i<j<k):
1. arr[i] < arr[i] < arr[k]
2. arr[i] == arr[j] < arr[k]
3. arr[i] < arr[j] == arr[k]
4. arr[i] == arr[j] == arr[k]

分清情况以后就是排列组合问题了，所以在对arr进行sort时，可以用bucket sort。