### 解题思路：
通过题意得知，连续重复的character长度最长为2，不妨从给定元素的频次出发，为了能得到最长string，每次选择character时，尽可能
选择频次高的character，频次最高的选择两个，次高的选择1个，尽可能让abc三种元素的频次趋于相同；当abc相同时，很容易想到只需要
abc一次排列即可用完所有元素。