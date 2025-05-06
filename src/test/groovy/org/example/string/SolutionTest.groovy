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

    def "Test checkInclusion"() {
        expect:
            solution.checkInclusion(t, s) == expected

        where:
            s                   | t          | expected
            "abcd"              | "abcd"     | true
            "abcd"              | "acbd"     | true
            "abcd"              | "abce"     | false
            "eidbaooo"          | "ab"       | true
            "eidboaoo"          | "ab"       | false
            "abcde"             | "cde"      | true
            "a"                 | "a"        | true
            "a"                 | "aa"       | false
            ""                  | "a"        | false
            "adcada"            | "abc"      | false
    }
}
