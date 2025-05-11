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
            nums                   | val | expectedK | expectedArray
            []                     | 0   | 0         | []
            [3, 2, 2, 3]           | 3   | 2         | [2, 2]
            [0, 1, 2, 2, 3, 0, 4]  | 2   | 5         | [0, 1, 3, 0, 4]
            [1, 1, 1, 1]           | 1   | 0         | []
            [5, 4, 3, 2, 1]        | 6   | 5         | [5, 4, 3, 2, 1]
            [2, 2, 2, 2]           | 2   | 0         | []
    }

    def "Test moveZeroes"() {
        given:
            int[] originalNums = Arrays.copyOf(nums as int[], nums.size())

        when:
            solution.moveZeroes(originalNums)

        then:
            Arrays.equals(originalNums, expectedArray as int[])

        where:
            nums                   | expectedArray
            []                     | []
            [0]                    | [0]
            [1, 0, 2]              | [1, 2, 0]
            [0, 0, 1]              | [1, 0, 0]
            [1, 2, 3]              | [1, 2, 3]
            [4, 0, 5, 0, 6, 0]     | [4, 5, 6, 0, 0, 0]
            [0, 1, 0, 3, 12]       | [1, 3, 12, 0, 0]
    }

    def "Test twoSum"() {
        when:
            int[] result = solution.twoSum(numbers as int[], target)

        then:
            Arrays.equals(result, expectedIndices as int[])

        where:
            numbers           | target | expectedIndices
            [2, 7, 11, 15]    | 9      | [1, 2]
            [1, 2, 4]         | 6      | [2, 3]
            [0, 0]            | 0      | [1, 2]
            [-1, 5, 8]        | 4      | [1, 2]
            [1, 3, 5, 7]      | 10     | [2, 4]
            [1, 2, 3]         | 7      | [-1, -1]
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
            nums                   | target | expectedResult
            [1, 0, -1, 2, -2]      | 0      | [[-2, 0, 2], [-1, 0, 1]] // 示例期望结果
            [2, 7, 11, 15]         | 20     | [[2, 7, 11]] // 2 + 7 + 11 = 20
            [1, 2, 3]              | 6      | [[1, 2, 3]] // 1 + 2 + 3 = 6
            [1, 3, 5, 7]           | 15     | [[3, 5, 7]] // 3 + 5 + 7 = 15
            [1, 2, 3]              | 7      | [] // 无法找到符合条件的组合
            [0, 0, 0]              | 0      | [[0, 0, 0]] // 所有元素都是 0
            []                     | 5      | [] // 空数组无法找到结果
            [1, -1, 0]             | 0      | [[-1, 0, 1]] // 测试负数和正数组合
    }

    def "Test nSumTarget"() {
        when:
            List<List<Integer>> result = solution.nSumTarget(nums as int[], n, 0, target)
        then:
            result.containsAll(expectedResult)
        where:
            nums                   | n   | target | expectedResult
            [1, 0, -1, 2, -2]      | 4   | 0      | [[-2, -1, 1, 2]] // -2 + (-1) + 1 + 2 == 0
            [2, 7, 11, 15]         | 3   | 24     | [[2, 7, 15]] // 2 + 7 + 15 == 24
            [1, 2, 3, 4]           | 2   | 5      | [[1, 4], [2, 3]] // 1+4=5, 2+3=5
            [1, 2, 3, 4]           | 4   | 10     | [[1, 2, 3, 4]] // 1+2+3+4 == 10
            [1, 2, 3]              | 3   | 6      | [[1, 2, 3]] // 1+2+3 == 6
            []                     | 2   | 5      | [] // 空数组无法找到结果
            [0, 0, 0, 0]           | 4   | 0      | [[0, 0, 0, 0]] // 所有元素都是0
    }

    def "Test rotate"() {
        given:
            int[][] matrix = input as int[][]

        when:
            solution.rotate(matrix)

        then:
            Arrays.deepEquals(matrix, expected as int[][])

        where:
            input                             | expected
            []                                | []                        // 空矩阵
            [[1]]                             | [[1]]                    // 单元素矩阵
            [[1, 2], [3, 4]]                  | [[3, 1], [4, 2]]        // 2x2 矩阵
            [[1, 2, 3], [4, 5, 6], [7, 8, 9]] | [[7, 4, 1], [8, 5, 2], [9, 6, 3]] // 3x3 矩阵
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
}
