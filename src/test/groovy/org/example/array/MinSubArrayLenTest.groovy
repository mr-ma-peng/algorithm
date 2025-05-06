package org.example.array

import spock.lang.Specification
import spock.lang.Unroll

class MinSubArrayLenTest extends Specification {
    private MinSubArrayLen minSubArrayLen = new MinSubArrayLen()

    @Unroll
    def "Test minSubArrayLen"() {
        expect:
            minSubArrayLen.minSubArrayLen(target, nums as int[]) == expected

        where:
            target | nums                     | expected
            7      | [2, 3, 1, 2, 4, 3]       | 2   // [4,3] 是最小子数组
            4      | [1, 4, 4]                | 1   // [4] 是最小子数组
            11     | [1, 1, 1, 1, 1, 1, 1, 1] | 0   // 没有满足条件的子数组
            5      | [2, 1, 4]                | 2   // [1,4] 是最小子数组
            5      | [5]                      | 1   // 只有一个元素且等于目标值
    }
}
