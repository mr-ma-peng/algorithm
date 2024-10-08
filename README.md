# algorithm
practice algorithm

## array
### MountainClimber
1. 问题拆解，最小问题模式（一座山峰）
2. 遍历O（n）数组
   1. 找到山峰
   2. 找到谷底
   3. 遍历山峰，start， peak， end
   4. 体力符合的山峰计数

### MountainPeaksCounter
1. 边界条件
2. O（n） 遍历获取左增右减的山峰

## string
### LongestEvenO
1. s + s
2. 前缀和
3. 哈希表记录每个前缀和第一次出现的位置
4. 遍历前缀和，找到最长的偶数长度的子串

### SmallestSubsequence
1. 双循环，找到最小的字符
2. 外部变量记录字符出现次数

## search
### BinarySearch
1. 迭代
   1. while 循环 找中值
2. 递归
