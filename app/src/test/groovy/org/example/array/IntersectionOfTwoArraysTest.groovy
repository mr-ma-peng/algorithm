package org.example.array

import spock.lang.Specification
import spock.lang.Unroll

class IntersectionOfTwoArraysTest extends Specification {

    private IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays()

    @Unroll
    def "Test intersectionBySet"() {
        when:
            Integer[] result = intersectionOfTwoArrays.intersectionBySet(nums1 as int[], nums2 as int[])
        then:
            Arrays.equals(result, expected as Integer[])

        where:
            nums1           | nums2       | expected
            [1, 2, 2, 1]    | [2, 2]     | [2]
            [1, 2, 3]       | [4, 5, 6]  | []
            []              | [1, 2]     | []
            [1, 2, 3]       | []         | []
            [3, 4, 5]       | [3, 4, 5]  | [3, 4, 5]
            [1, 2, 3, 3]    | [2, 3]     | [2, 3]
    }

    @Unroll
    def "Test intersectionByMap"() {
        when:
            Integer[] result = intersectionOfTwoArrays.intersectionByMap(nums1 as int[], nums2 as int[])

        then:
            Arrays.equals(result, expected as Integer[])

        where:
            nums1           | nums2       | expected
            [1, 2, 2, 1]    | [2, 2]     | [2, 2]
            [1, 2, 3]       | [4, 5, 6]  | []
            []              | [1, 2]     | []
            [1, 2, 3]       | []         | []
            [3, 4, 5]       | [3, 4, 5]  | [3, 4, 5]
            [1, 2, 3, 3]    | [2, 3]     | [2, 3]
            [1, 2, 2, 1]    | [2]        | [2]
    }

}
