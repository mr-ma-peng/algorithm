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
   2. 遍历数组，遇到0，交换0的指针和当前指针，遇到2，交换2的指针和当前指针
   3. 交换后，当前指针不变
### MinSubArrayLen
1. 滑动窗口
   1. 两个指针，l， r
   2. l指针遍历数组，r指针记录满足条件的子数组
   3. 满足条件的子数组，l指针右移
   4. 不满足条件的子数组，r指针右移

### MountainPeaksCounter
1. 边界条件
2. O（n） 遍历获取左增右减的山峰

### IntersectionOfTwoArrays
1. 两个集合
   1. 遍历一个集合，另一个集合查找
2. map 记录次数

## String
### LongestEvenO
1. s + s
2. 前缀和
3. 哈希表记录每个前缀和第一次出现的位置
4. 遍历前缀和，找到最长的偶数长度的子串
### LengthOfLongestSubstring
1. 滑动窗口
   1. 两个指针，l， r
   2. r指针遍历字符串，l指针记录满足条件的子串
   3. 满足条件的子串，l指针右移
   4. 不满足条件的子串，r指针右移
   5. freq记录字符出现次数

### SmallestSubsequence
1. 双循环，找到最小的字符
2. 外部变量记录字符出现次数

## search
### BinarySearch
1. 迭代
   1. while 循环 找中值
2. 递归

## LinkedList
### ReverseLinkedList
1. 节点类
   1. 存储数据和对下一个节点的引用
2. 链表类
   1. append
      1. 在链表末尾添加一个新节点
   2. printList
      1. 打印链表中的所有元素
   3. reverse
      1. 反转链表
   4. reverse m n
      1. 反转链表中的m到n的元素
