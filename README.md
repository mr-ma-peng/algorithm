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
### MoveZeros
1. 双指针
   1. 一个指针遍历，一个指针记录非零元素
   2. 遍历结束，非零元素后的元素置零
   3. 交换非零元素和零元素
### SortColors
1. 双指针
   1. 一个指针记录0，一个指针记录2
   2. 遍历数组，遇到0，交换0指针和当前指针，遇到2，交换2指针和当前指针
   3. 交换后，当前指针不变

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
