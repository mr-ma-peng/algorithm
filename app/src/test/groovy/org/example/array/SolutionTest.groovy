package org.example.array

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    private Solution solution = new Solution();

    @Unroll
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
}
