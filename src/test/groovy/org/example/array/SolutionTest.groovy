package org.example.array

import spock.lang.Specification

class SolutionTest extends Specification {

    private Solution solution = new Solution()

    def "Test removeDuplicates"() {
        given:
            int[] originalNums = Arrays.copyOf(nums as int[], nums.size())

        when:
            int k = solution.removeDuplicates(originalNums)

        then:
            k == expectedK
            Arrays.equals(Arrays.copyOf(originalNums, k), expectedArray as int[])

        where:
            nums                           | expectedK | expectedArray
            []                             | 0         | []
            [1]                            | 1         | [1]
            [1, 1, 1]                      | 1         | [1]
            [0, 0, 1, 1, 1, 2]             | 3         | [0, 1, 2]
            [1, 2, 3]                      | 3         | [1, 2, 3]
            [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] | 5         | [0, 1, 2, 3, 4]
    }

    def "Test removeElement"() {
        given:
            int[] originalNums = Arrays.copyOf(nums as int[], nums.size())

        when:
            int k = solution.removeElement(originalNums, val)

        then:
            k == expectedK
            Arrays.equals(Arrays.copyOf(originalNums, k), expectedArray as int[])

        where:
            nums                  | val | expectedK | expectedArray
            []                    | 0   | 0         | []
            [3, 2, 2, 3]          | 3   | 2         | [2, 2]
            [0, 1, 2, 2, 3, 0, 4] | 2   | 5         | [0, 1, 3, 0, 4]
            [1, 1, 1, 1]          | 1   | 0         | []
            [5, 4, 3, 2, 1]       | 6   | 5         | [5, 4, 3, 2, 1]
            [2, 2, 2, 2]          | 2   | 0         | []
    }

    def "Test moveZeroes"() {
        given:
            int[] originalNums = Arrays.copyOf(nums as int[], nums.size())

        when:
            solution.moveZeroes(originalNums)

        then:
            Arrays.equals(originalNums, expectedArray as int[])

        where:
            nums               | expectedArray
            []                 | []
            [0]                | [0]
            [1, 0, 2]          | [1, 2, 0]
            [0, 0, 1]          | [1, 0, 0]
            [1, 2, 3]          | [1, 2, 3]
            [4, 0, 5, 0, 6, 0] | [4, 5, 6, 0, 0, 0]
            [0, 1, 0, 3, 12]   | [1, 3, 12, 0, 0]
    }

    def "Test twoSum"() {
        when:
            int[] result = solution.twoSum(numbers as int[], target)

        then:
            Arrays.equals(result, expectedIndices as int[])

        where:
            numbers        | target | expectedIndices
            [2, 7, 11, 15] | 9      | [1, 2]
            [1, 2, 4]      | 6      | [2, 3]
            [0, 0]         | 0      | [1, 2]
            [-1, 5, 8]     | 4      | [1, 2]
            [1, 3, 5, 7]   | 10     | [2, 4]
            [1, 2, 3]      | 7      | [-1, -1]
    }

    def "Test twoSumTarget"() {
        when:
            List<List<Integer>> result = solution.twoSumTarget(nums as int[], target, null, null)
        then:
            result.containsAll(expectedResult)
        where:
            nums              | target | expectedResult
            [1, 0, -1, 2, -2] | 0      | [[-2, 2], [-1, 1]]
            [2, 7, 11, 15]    | 9      | [[2, 7]]
            [1, 2, 3]         | 4      | [[1, 3]]
            [1, 3, 5, 7]      | 8      | [[1, 7], [3, 5]]
            [1, 2, 3]         | 7      | []
            [0, 0, 0]         | 0      | [[0, 0]]
            []                | 5      | []
            [1, -1]           | 0      | [[-1, 1]]
    }

    def "Test threeSumTarget"() {
        when:
            List<List<Integer>> result = solution.threeSumTarget(nums as int[], target)
        then:
            result.containsAll(expectedResult)
        where:
            nums              | target | expectedResult
            [1, 0, -1, 2, -2] | 0      | [[-2, 0, 2], [-1, 0, 1]] // 示例期望结果
            [2, 7, 11, 15]    | 20     | [[2, 7, 11]] // 2 + 7 + 11 = 20
            [1, 2, 3]         | 6      | [[1, 2, 3]] // 1 + 2 + 3 = 6
            [1, 3, 5, 7]      | 15     | [[3, 5, 7]] // 3 + 5 + 7 = 15
            [1, 2, 3]         | 7      | [] // 无法找到符合条件的组合
            [0, 0, 0]         | 0      | [[0, 0, 0]] // 所有元素都是 0
            []                | 5      | [] // 空数组无法找到结果
            [1, -1, 0]        | 0      | [[-1, 0, 1]] // 测试负数和正数组合
    }

    def "Test nSumTarget"() {
        when:
            List<List<Integer>> result = solution.nSumTarget(nums as int[], n, 0, target)
        then:
            result.containsAll(expectedResult)
        where:
            nums              | n | target | expectedResult
            [1, 0, -1, 2, -2] | 4 | 0      | [[-2, -1, 1, 2]] // -2 + (-1) + 1 + 2 == 0
            [2, 7, 11, 15]    | 3 | 24     | [[2, 7, 15]] // 2 + 7 + 15 == 24
            [1, 2, 3, 4]      | 2 | 5      | [[1, 4], [2, 3]] // 1+4=5, 2+3=5
            [1, 2, 3, 4]      | 4 | 10     | [[1, 2, 3, 4]] // 1+2+3+4 == 10
            [1, 2, 3]         | 3 | 6      | [[1, 2, 3]] // 1+2+3 == 6
            []                | 2 | 5      | [] // 空数组无法找到结果
            [0, 0, 0, 0]      | 4 | 0      | [[0, 0, 0, 0]] // 所有元素都是0
    }

    def "Test rotateClockwise"() {
        given:
            int[][] matrix = input as int[][]

        when:
            solution.rotateClockwise(matrix)

        then:
            Arrays.deepEquals(matrix, expected as int[][])

        where:
            input                             | expected
            []                                | []                        // 空矩阵
            [[1]]                             | [[1]]                    // 单元素矩阵
            [[1, 2], [3, 4]]                  | [[3, 1], [4, 2]]        // 2x2 矩阵
            [[1, 2, 3], [4, 5, 6], [7, 8, 9]] | [[7, 4, 1], [8, 5, 2], [9, 6, 3]] // 3x3 矩阵
    }

    def "Test rotateCounterClockwise"() {
        given:
            int[][] matrix = input as int[][]

        when:
            solution.rotateCounterClockwise(matrix)

        then:
            Arrays.deepEquals(matrix, expected as int[][])

        where:
            input                             | expected
            []                                | []                        // 空矩阵
            [[1]]                             | [[1]]                    // 单元素矩阵
            [[1, 2], [3, 4]]                  | [[2, 4], [1, 3]]        // 2x2 矩阵逆时针旋转
            [[1, 2, 3], [4, 5, 6], [7, 8, 9]] | [[3, 6, 9], [2, 5, 8], [1, 4, 7]] // 3x3 矩阵逆时针旋转
    }


    def "Test reverse"() {
        given:
            int[] arr = input as int[]

        when:
            solution.reverse(arr)

        then:
            Arrays.equals(arr, expected as int[])

        where:
            input        | expected
            []           | []                   // 空数组
            [1]          | [1]                 // 单元素数组
            [1, 2, 3]    | [3, 2, 1]
            [4, 5, 6, 7] | [7, 6, 5, 4]
            [0, 0, 0]    | [0, 0, 0]          // 全相同元素
            [-1, 0, 1]   | [1, 0, -1]
    }

    def "Test intersectionBySet"() {
        when:
            Integer[] result = solution.intersectionBySet(nums1 as int[], nums2 as int[])
        then:
            Arrays.equals(result, expected as Integer[])

        where:
            nums1        | nums2     | expected
            [1, 2, 2, 1] | [2, 2]    | [2]
            [1, 2, 3]    | [4, 5, 6] | []
            []           | [1, 2]    | []
            [1, 2, 3]    | []        | []
            [3, 4, 5]    | [3, 4, 5] | [3, 4, 5]
            [1, 2, 3, 3] | [2, 3]    | [2, 3]
    }

    def "Test intersectionByMap"() {
        when:
            Integer[] result = solution.intersectionByMap(nums1 as int[], nums2 as int[])

        then:
            Arrays.equals(result, expected as Integer[])

        where:
            nums1        | nums2     | expected
            [1, 2, 2, 1] | [2, 2]    | [2, 2]
            [1, 2, 3]    | [4, 5, 6] | []
            []           | [1, 2]    | []
            [1, 2, 3]    | []        | []
            [3, 4, 5]    | [3, 4, 5] | [3, 4, 5]
            [1, 2, 3, 3] | [2, 3]    | [2, 3]
            [1, 2, 2, 1] | [2]       | [2]
    }

    def "Test minSubArrayLen"() {
        expect:
            solution.minSubArrayLen(target, nums as int[]) == expected

        where:
            target | nums                     | expected
            7      | [2, 3, 1, 2, 4, 3]       | 2   // [4,3] 是最小子数组
            4      | [1, 4, 4]                | 1   // [4] 是最小子数组
            11     | [1, 1, 1, 1, 1, 1, 1, 1] | 0   // 没有满足条件的子数组
            5      | [2, 1, 4]                | 2   // [1,4] 是最小子数组
            5      | [5]                      | 1   // 只有一个元素且等于目标值
    }

    def "Test spiralOrder"() {
        when:
            List<Integer> result = solution.spiralOrder(matrix as int[][])

        then:
            result == expected

        where:
            matrix                            | expected
            []                                | []                                          // 空矩阵
            [[1]]                             | [1]                                        // 单个元素
            [[1, 2, 3]]                       | [1, 2, 3]                                  // 单行矩阵
            [[1], [2], [3]]                   | [1, 2, 3]                                  // 单列矩阵
            [[1, 2], [3, 4]]                  | [1, 2, 4, 3]                               // 2x2 矩阵
            [[1, 2, 3], [4, 5, 6], [7, 8, 9]] | [1, 2, 3, 6, 9, 8, 7, 4, 5]         // 3x3 矩阵
            [[1, 2, 3, 4], [5, 6, 7, 8]]      | [1, 2, 3, 4, 8, 7, 6, 5]                 // 2x4 矩阵
            [[1, 2], [3, 4], [5, 6]]          | [1, 2, 4, 6, 5, 3]                         // 3x2 矩阵
    }

    def "Test generateMatrix"() {
        when:
            int[][] result = solution.generateMatrix(n)

        then:
            Arrays.deepEquals(result, expected as int[][])

        where:
            n | expected
            0 | []                                                    // n = 0，返回空矩阵
            1 | [[1]]                                                 // n = 1
            2 | [[1, 2], [4, 3]]                                      // n = 2，顺时针螺旋
            3 | [[1, 2, 3], [8, 9, 4], [7, 6, 5]]                     // n = 3，螺旋填充
            4 | [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]] // n = 4
    }

    def "Test sortColors"() {
        given:
            int[] nums = input as int[]

        when:
            solution.sortColors(nums)

        then:
            Arrays.equals(nums, expected as int[])

        where:
            input           | expected
            []              | []                      // 空数组
            [0]             | [0]                     // 单个元素
            [1, 0]          | [0, 1]                  // 两个元素
            [2, 0, 1]       | [0, 1, 2]               // 三个不同颜色
            [2, 2, 1, 1, 0] | [0, 1, 1, 2, 2]         // 包含重复颜色
            [0, 0, 0]       | [0, 0, 0]               // 全为 0
            [1, 1, 1]       | [1, 1, 1]               // 全为 1
            [2, 2, 2]       | [2, 2, 2]               // 全为 2
            [1, 2, 0]       | [0, 1, 2]               // 乱序排列
            [2, 1, 0, 2]    | [0, 1, 2, 2]            // 多种颜色混合
    }

    def "Test merge"() {
        given:
            int[] nums1 = inputNums1 as int[]
            int m = inputM
            int[] nums2 = inputNums2 as int[]
            int n = inputN

        when:
            solution.merge(nums1, m, nums2, n)

        then:
            Arrays.equals(nums1, expected as int[])

        where:
            inputNums1         | inputM | inputNums2 | inputN | expected
            [1, 2, 3, 0, 0, 0] | 3      | [2, 5, 6]  | 3      | [1, 2, 2, 3, 5, 6]
            [1, 0, 0, 0]       | 1      | [2, 3, 4]  | 3      | [1, 2, 3, 4]
            [4, 5, 6, 0, 0, 0] | 3      | [1, 2, 3]  | 3      | [1, 2, 3, 4, 5, 6]
            [0, 0, 0]          | 0      | [1, 2, 3]  | 3      | [1, 2, 3]
            [1, 2, 3]          | 3      | []         | 0      | [1, 2, 3]
            []                 | 0      | []         | 0      | []
            [0, 0, 0, 0]       | 2      | [1, 2]     | 2      | [0, 0, 1, 2]
    }

    def "Test sortedSquares"() {
        when:
            int[] result = solution.sortedSquares(nums as int[])

        then:
            Arrays.equals(result, expected as int[])

        where:
            nums              | expected
            []                | []
            [1]               | [1]
            [1, 2, 3]         | [1, 4, 9]
            [-3, -2, 0, 1, 2] | [0, 1, 4, 4, 9]
            [-5, -3, -1]      | [1, 9, 25]
            [0, 0, 0]         | [0, 0, 0]
            [-2, -1, 0, 3, 4] | [0, 1, 4, 9, 16]
    }
}
