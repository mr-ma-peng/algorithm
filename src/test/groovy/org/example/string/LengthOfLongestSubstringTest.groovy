package org.example.string

import spock.lang.Specification
import spock.lang.Unroll

class LengthOfLongestSubstringTest extends Specification {

    private LengthOfLongestSubstring solver = new LengthOfLongestSubstring()

    @Unroll
    def "Test lengthOfLongestSubstringUsingArray"() {
        expect:
            solver.lengthOfLongestSubstringUsingArray(input as String) == expected

        where:
            input           | expected
            "abcabcbb"      | 3
            "bbbbb"         | 1
            "pwwkew"        | 3
            ""              | 0
            "abcdef"        | 6
            "aab"           | 2
    }

    @Unroll
    def "Test lengthOfLongestSubstringUsingMap"() {
        expect:
            solver.lengthOfLongestSubstringUsingMap(input as String) == expected

        where:
            input           | expected
            "abcabcbb"      | 3
            "bbbbb"         | 1
            "pwwkew"        | 3
            ""              | 0
            "abcdef"        | 6
            "aab"           | 2
    }
}
