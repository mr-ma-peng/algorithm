package org.example.search

import spock.lang.Specification

class SolutionTest extends Specification {

    private Solution binarySearch = new Solution()

    def "Test BinarySearch"() {
        expect:
            binarySearch.binarySearch(array as int[], target) == expected

        where:
            array                               | target | expected
            [1, 3, 4, 5, 7, 11, 15, 17, 22, 45] | 7      | 4
            [1, 3, 4, 5, 7, 11, 15, 17, 22, 45] | 1      | 0
            [1, 3, 4, 5, 7, 11, 15, 17, 22, 45] | 45     | 9
            [1, 3, 4, 5, 7, 11, 15, 17, 22, 45] | 2      | -1
            [1, 3, 4, 5, 7, 11, 15, 17, 22, 45] | 100    | -1
            []                                  | 5      | -1
            [10]                                | 10     | 0
            [10]                                | 5      | -1
    }
}
