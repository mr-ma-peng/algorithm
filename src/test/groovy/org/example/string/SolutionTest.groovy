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
            s          | t      | expected
            "abcd"     | "abcd" | true
            "abcd"     | "acbd" | true
            "abcd"     | "abce" | false
            "eidbaooo" | "ab"   | true
            "eidboaoo" | "ab"   | false
            "abcde"    | "cde"  | true
            "a"        | "a"    | true
            "a"        | "aa"   | false
            ""         | "a"    | false
            "adcada"   | "abc"  | false
    }

    def "Test findAnagrams"() {
        expect:
            solution.findAnagrams(s, t) == expected

        where:
            s            | t     | expected
            "cbaebabacd" | "abc" | [0, 6]
            "abab"       | "ab"  | [0, 1, 2]
            "abcdefg"    | "xyz" | []
            "aaaaa"      | "aaa" | [0, 1, 2]
            "abacbabc"   | "abc" | [1, 2, 3, 5]
            ""           | "a"   | []
            "aa"         | "a"   | [0, 1]
    }

    def "Test reverseWords"() {
        expect:
            solution.reverseWords(s) == expected

        where:
            s                 | expected
            "the sky is blue" | "blue is sky the"
            "  hello world  " | "world hello"
            "a"               | "a"
            ""                | ""
            "   a   b c  "    | "c b a"
    }

    def "Test lengthOfLongestSubstringUsingArray"() {
        expect:
            solution.lengthOfLongestSubstringUsingArray(input as String) == expected

        where:
            input      | expected
            "abcabcbb" | 3
            "bbbbb"    | 1
            "pwwkew"   | 3
            ""         | 0
            "abcdef"   | 6
            "aab"      | 2
    }

    def "Test lengthOfLongestSubstringUsingMap"() {
        expect:
            solution.lengthOfLongestSubstringUsingMap(input as String) == expected

        where:
            input      | expected
            "abcabcbb" | 3
            "bbbbb"    | 1
            "pwwkew"   | 3
            ""         | 0
            "abcdef"   | 6
            "aab"      | 2
    }

    def "Test sensitiveFieldEncrypted"() {
        expect:
            solution.sensitiveFieldEncrypted(input as String, k as int) == expected

        where:
            input                           | k | expected
            'user_name_password_'           | 2 | 'user_name_******'
            'user_name_password_'           | 0 | '******_name_password'
            'user_name_password_'           | 1 | 'user_******_password'
            '"quoted_field"_normal_field_'  | 1 | '"quoted_field"_******_field'
            '"first_part"_second_part_'     | 0 | '******_second_part'
            'only_one_part_'                | 0 | '******_one_part'
            'only_one_part_'                | 1 | 'only_******_part'
            'a_b_c_d_'                      | 3 | 'a_b_c_******'
            'a_b_c_d_'                      | 5 | 'ERROR'
            'field_with_"under_score"_'     | 0 | '******_with_"under_score"'
            'field_with_"under_score"_end_' | 2 | 'field_with_******_end'
    }

    def "Test longestPalindrome"() {
        expect:
            solution.longestPalindrome(input as String) == expected

        where:
            input          | expected
            "cbbd"         | "bb"   // 中间两个相同字符的最长回文子串
            "a"            | "a"    // 单个字符输入
            "racecar"      | "racecar" // 完整的回文字符串
            "abacdfgdcaba" | "aba" // 存在多个可能的回文，但最长为 "aba"
            "abba"         | "abba" // 偶数长度的回文
            ""             | ""     // 空字符串输入
            "aaa"          | "aaa"  // 所有字符都相同
            "aaaaa"        | "aaaaa"// 长度为奇数的全相同字符
    }
}
