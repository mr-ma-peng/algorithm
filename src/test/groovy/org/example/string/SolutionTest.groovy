package org.example.string

import spock.lang.Specification

class SolutionTest extends Specification {
    private Solution solution = new Solution()

    def "Test minWindow"() {
        expect:
            solution.minWindow(s, t) == expected

        where:
            s                | t      | expected
            "ADOBECODEBANC"  | "ABC"  | "BANC"
            "a"              | "a"    | "a"
            "a"              | "aa"   | ""
            "ADOBECODEBAANC" | "AABC" | "BAANC"
            ""               | "a"    | ""
            "abcdef"         | "xyz"  | ""
            "aabdec"         | "abc"  | "abdec"
    }
}
