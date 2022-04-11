### 解题思路：
本题需要找到分成m组，使得分别所有subarray的和的最大值最小。不妨使用二分猜值法，在[0, Integer.MAX_VALUE]之间一定存在一个
值target，target满足nums分成m分且target是这些subarray和中的最大值，而且target也是所有方案中最小的最大值。因此问题转化为
：如何判断target是不是满足这些条件。因此可以直接遍历nums，每次满足subarray的和 尽可能取大 并且 小于等于target。如果最终
分成的subarray个数小于等于m，说明猜的target有可能偏小，需要猜更大的target；反之需要猜更小的target。