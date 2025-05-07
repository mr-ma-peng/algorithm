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
}
