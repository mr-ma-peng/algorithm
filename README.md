Algorithm Practice
这是一个用于练习算法的项目，包含多个常见数据结构与算法问题的实现。主要分为以下几个模块：array、string、search 和 linkedlist。
## 📁 目录结构

```text
.
├── src
│   ├── main
│   │   ├── java/org/example
│   │   │   ├── array
│   │   │   │   └── Solution.java        # 数组相关算法
│   │   │   ├── linkedlist
│   │   │   │   ├── ListNode.java          # 单链表节点类
│   │   │   │   ├── DoublyListNode.java    # 双链表节点类
│   │   │   │   └── Solution.java          # 链表操作
│   │   │   ├── search
│   │   │   │   └── Solution.java          # 搜索算法（如二分查找）
│   │   │   └── string
│   │   │       └── Solution.java          # 字符串处理算法
│   │   └── resources                      # 资源文件
│   └── test
│       ├── groovy/org/example
│       │   ├── array
│       │   │   └── SolutionTest.groovy    # 数组单元测试
│       │   ├── linkedlist
│       │   │   └── SolutionTest.groovy    # 链表单元测试
│       │   ├── search
│       │   │   └── SolutionTest.groovy    # 搜索单元测试
│       │   └── string
│       │       └── SolutionTest.groovy    # 字符串单元测试
│       └── resources
├── LICENSE                                # Apache License 2.0
├── README.md                              # 当前文档
├── build.gradle                           # Gradle 构建脚本
├── gradlew                                # Unix 启动脚本
├── gradlew.bat                            # Windows 启动脚本
└── settings.gradle                        # Gradle 设置

```


## 📁 array 模块
🔍 文件：Solution.java
1. [twoSumTarget(int[] nums, Integer target, Integer start, Integer end)](src/main/java/org/example/array/Solution.java#L69)
   - 功能：查找两个数之和等于目标值的所有组合。
   - 实现方式：
     - 使用双指针法。
     - 对数组进行排序后，从指定范围 `[start, end]` 内搜索满足条件的组合。
     - 去重处理（跳过重复元素）。
2. [threeSumTarget(int[] nums, int target)](src/main/java/org/example/array/Solution.java#L92)
   - 功能：查找三个数之和等于目标值的所有组合。
   - 实现方式：
     - 外层循环遍历每个元素，将其作为第一个数。
     - 内部调用 `twoSumTarget()` 寻找剩下的两个数。
     - 去重处理（跳过重复元素）。
3. [nSumTarget(int[] nums, int n, int start, long target)](src/main/java/org/example/array/Solution.java#L109)
   - 功能：查找任意 n 个数之和等于目标值的所有组合。
   - 实现方式：
     - 递归实现。
     - 当 `n == 2` 时，使用双指针法。
     - 当 `n > 2` 时，递归调用 `nSumTarget(nums, n - 1, i + 1, target - nums[i])`。
     - 去重处理（跳过重复元素）。
4. [rotateClockwise(int[][] matrix)](src/main/java/org/example/array/Solution.java#L146)
   - 功能：顺时针旋转二维矩阵 90 度。
   - 实现方式：
     - 先对角线翻转（交换 `matrix[i][j]` 和 `matrix[j][i]`）。
     - 然后每行反转（使用 `reverse()` 方法）。
5. [rotateCounterClockwise(int[][] matrix)](src/main/java/org/example/array/Solution.java#L160)
   - 功能：逆时针旋转二维矩阵 90 度。
   - 实现方式：
     - 先反向对角线翻转（交换 `matrix[i][j]` 和 `matrix[len - j - 1][len - i - 1]`）。
     - 然后每行反转（使用 `reverse()` 方法）。
6. [reverse(int[] arr)](src/main/java/org/example/array/Solution.java#L174)
   - 功能：原地反转数组。
   - 实现方式：
     - 双指针法，交换头尾元素直到相遇。
7. [intersectionBySet(int[] nums1, int[] nums2)](src/main/java/org/example/array/Solution.java#L186)
   - 功能：返回两个数组的交集（不包含重复元素）。
   - 实现方式：
     - 使用 `HashSet` 存储第一个数组的元素。
     - 遍历第二个数组，如果在集合中存在，则加入结果集合。
8. [intersectionByMap(int[] nums1, int[] nums2)](src/main/java/org/example/array/Solution.java#L200)
   - 功能：返回两个数组的交集（包含重复元素）。
   - 实现方式：
     - 使用 `HashMap` 记录第一个数组中每个元素出现的次数。
     - 遍历第二个数组，如果存在且次数大于 0，则加入结果并减少次数。
9. [sortColors(int[] nums)](src/main/java/org/example/array/Solution.java#L320)
   - 功能：对一个包含红、白、蓝三种颜色（分别用数字 0、1 和 2 表示）的数组进行原地排序。
   - 实现方式：
     - 使用双指针 + 当前指针策略（三指针法）。
     - p0 指向 0 的边界位置，p2 指向 2 的边界位置，p 是当前遍历的位置。
     - 遍历时根据当前元素值决定操作：
       - 若为 0，将其交换到 p0 边界，并右移 p0 和 p。
       - 若为 2，将其交换到 p2 边界，并左移 p2。
       - 若为 1，直接右移 p。
     - 时间复杂度为 O(n)，空间复杂度为 O(1)。
10. [merge(int[] nums1, int m, int[] nums2, int n)](src/main/java/org/example/array/Solution.java#L344)
    - 功能：将两个有序数组 `nums1` 和 `nums2` 合并为一个有序数组，并存储在 `nums1` 中。
    - 实现方式：
        - 使用双指针法，从后往前合并。
        - 比较 `nums1` 和 `nums2` 的元素，将较大的元素放在 `nums1` 的末尾。
        - 时间复杂度为 O(m + n)，空间复杂度为 O(1)。
11. [sortedSquares(int[] nums)](src/main/java/org/example/array/Solution.java#L360)
    - 功能：将一个非递减顺序排列的整数数组中的每个元素平方后，按非递减顺序返回。
    - 实现方式：
        - 使用双指针法，一个指针指向开头，另一个指针指向末尾。
        - 比较两个指针对应元素的绝对值大小，将较大者的平方放入结果数组的末尾。
        - 时间复杂度为 O(n)，空间复杂度为 O(n)。

## 📁 string 模块
🔍 文件：Solution.java
1. [minWindow(String s, String t)](src/main/java/org/example/string/Solution.java#L10)
   - 功能：在字符串 `s` 中找到包含所有 `t` 字符的最短子串。
   - 实现方式：
     - 滑动窗口算法。
     - 使用两个哈希表记录字符频率，一个记录需求，一个记录当前窗口内的字符。
     - 动态调整窗口大小以找到最小符合条件的子串。
2. [checkInclusion(String t, String s)](src/main/java/org/example/string/Solution.java#L48)
   - 功能：判断 `t` 是否是 `s` 的排列子串。
   - 实现方式：
     - 滑动窗口算法。
     - 维护固定大小的窗口，窗口大小等于 `t` 的长度。
     - 如果窗口内字符频率与 `t` 相同，则返回 `true`。
3. [findAnagrams(String s, String t)](src/main/java/org/example/string/Solution.java#L85)
   - 功能：查找 `s` 中所有 `t` 的变位词（字母异位词）的起始索引。
   - 实现方式：
     - 滑动窗口算法。
     - 窗口大小等于 `t` 的长度。
     - 每次滑动窗口，检查是否满足条件。
4. [lengthOfLongestSubstringUsingArray(String s)](src/main/java/org/example/string/Solution.java#L147)
   - 功能：查找不含重复字符的最长子串长度。
   - 实现方式：
     - 数组记录字符出现频率。
     - 滑动窗口算法。
5. [lengthOfLongestSubstringUsingMap(String s)](src/main/java/org/example/string/Solution.java#L167)
   - 功能：查找不含重复字符的最长子串长度。
   - 实现方式：
     - 使用哈希表记录字符频率。
     - 滑动窗口算法。
6. [sensitiveFieldEncrypted(String s, int k)](src/main/java/org/example/string/Solution.java#L189)
   - 功能：将第 `k` 个字段替换为 `"******"`，忽略被双引号包裹的部分。
   - 实现方式：
     - 遍历字符串，识别字段边界。
     - 替换第 `k` 个字段，其他字段保留。
7. [longestPalindrome(String s)](src/main/java/org/example/string/Solution.java#L218)
   - 功能：查找最长回文子串。
   - 实现方式：
     - 中心扩展法。
     - 分别考虑奇数和偶数长度的回文。
8. [reverseWords(String s)](src/main/java/org/example/string/Solution.java#L122)
   - 功能：反转字符串中的每个单词。
   - 实现方式：
     - 使用 `StringBuilder` 反转整个字符串。
     - 拆分字符串成单词列表。
     - 反转每个单词，并拼接成结果。
9. [isPalindrome(String s)](src/main/java/org/example/string/Solution.java#L238)
   - 功能：判断字符串是否为回文串。
   - 实现方式：
     - 过滤非字母数字字符，统一转为小写。
     - 双指针法检查字符对称性。

## 📁 linkedlist 模块
🔍 文件：Solution.java
1. [reverse(ListNode head)](src/main/java/org/example/linkedlist/Solution.java#L10)
   - 功能：反转链表。
   - 实现方式：
     - 迭代法，维护前驱节点、当前节点、后继节点。
2. [reverse(ListNode head, int m, int n)](src/main/java/org/example/linkedlist/Solution.java#L40)
   - 功能：反转链表中第 `m` 到 `n` 个节点。
   - 实现方式：
     - 找到第 `m` 个节点的前驱。
     - 反转 `m` 到 `n` 节点之间的部分。
     - 重新连接前后部分。
3. [mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2)](src/main/java/org/example/linkedlist/Solution.java#L48)
    - 功能：合并两个升序排列的链表为一个新的升序链表。
    - 实现方式：
      - 使用虚拟头节点 `dummy` 简化边界处理，通过双指针比较节点值大小依次拼接。
    - 时间复杂度：O(n + m)，其中 n 和 m 分别是链表 l1 和 l2 的长度。
    - 空间复杂度：O(1)（仅使用常量级额外空间）。
    - 应用场景：归并排序中的合并阶段、合并有序数据流。
4. [partition(ListNode<Integer> head, int x)](src/main/java/org/example/linkedlist/Solution.java#L72)
    - 功能：对链表进行分区，将所有小于等于 x 的节点移到前面，大于 x 的节点留在后面。
    - 实现方式：
        - 使用两个虚拟头节点分别记录小于等于 x 和大于 x 的子链表。
        - 遍历原始链表，将节点分别连接到对应的子链表。
        - 最后将两个子链表拼接。
    - 时间复杂度：O(n)，其中 n 是链表长度。
    - 空间复杂度：O(1)（仅使用常量级额外空间）。
    - 应用场景：快速排序中的划分阶段、数据分组处理。
5. [mergeKLists(ListNode<Integer>[] lists)](src/main/java/org/example/linkedlist/Solution.java#L98)
    - 功能：合并多个升序排列的链表为一个新的升序链表。
    - 实现方式：
      - 使用优先队列（PriorityQueue）维护当前各链表的头节点。
      - 每次从队列中取出值最小的节点，并将其下一个节点加入队列。
      - 直到队列为空，完成合并。
    - 时间复杂度：O(N log k)，其中 N 是所有链表中的总节点数，k 是链表数量。
    - 空间复杂度：O(k)（优先队列中最多存储 k 个节点）。
    - 应用场景：合并多个有序数据流、多路归并排序等场景。

## 📁 search 模块
🔍 文件：Solution.java
1. [binarySearch(int[] nums, int target)](src/main/java/org/example/search/Solution.java#L6)
   - 功能：查找有序数组中目标值的位置。
   - 实现方式：
     - 迭代法，每次比较中间值，缩小搜索范围。

## ✅ 测试文件
- 每个模块都有对应的测试类（如 `SolutionTest.groovy`），覆盖了各种边界情况和正常情况。
- 使用 [Spock Framework](https://spockframework.org/) 编写测试用例，支持数据驱动测试（`where:` 块）。
- 包括正向测试、负向测试、空输入、重复元素等场景。
