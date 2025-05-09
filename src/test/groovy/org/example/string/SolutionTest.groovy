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

    def "Test findAnagrams"() {
        expect:
            solution.findAnagrams(s, t) == expected

        where:
            s              | t      | expected
            "cbaebabacd"   | "abc"  | [0, 6]
            "abab"         | "ab"   | [0, 1, 2]
            "abcdefg"      | "xyz"  | []
            "aaaaa"        | "aaa"  | [0, 1, 2]
            "abacbabc"     | "abc"  | [1, 2, 3, 5]
            ""             | "a"    | []
            "aa"           | "a"    | [0, 1]
    }

    def "Test reverseWords"() {
        expect:
            solution.reverseWords(s) == expected

        where:
            s                          | expected
            "the sky is blue"         | "blue is sky the"
            "  hello world  "         | "world hello"
            "a"                       | "a"
            ""                        | ""
            "   a   b c  "            | "c b a"
    }

}
