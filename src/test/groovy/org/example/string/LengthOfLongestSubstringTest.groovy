package org.example.string

import spock.lang.Specification

class LengthOfLongestSubstringTest extends Specification {

    private LengthOfLongestSubstring solver = new LengthOfLongestSubstring()

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
