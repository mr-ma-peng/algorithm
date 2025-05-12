package org.example.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if ((right - left) < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public boolean checkInclusion(String t, String s) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while ((right - left) >= t.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        return false;
    }

    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }

            while ((right - left) >= t.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(windows.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        return result;
    }

    public String reverseWords(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = reverseSingleWord(new StringBuilder(s.trim()));
        List<StringBuilder> builderList = Arrays.stream(sb.toString().split("\\s+"))
                .map(StringBuilder::new)
                .toList();
        for (StringBuilder item : builderList) {
            result.add(reverseSingleWord(item).toString());
        }
        return String.join(" ", result);
    }

    private StringBuilder reverseSingleWord(StringBuilder sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
        return sb;
    }

    public int lengthOfLongestSubstringUsingArray(String s) {
        int[] frequency = new int[256];
        int left = 0;
        int right = -1;
        int result = 0;

        while (left < s.length()) {
            if (right + 1 < s.length() && frequency[s.charAt(right + 1)] == 0) {
                right++;
                frequency[s.charAt(right)]++;
            } else {
                frequency[s.charAt(left)]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public int lengthOfLongestSubstringUsingMap(String s){
        Map<Character, Integer> windows = new HashMap<>();

        int left = 0;
        int right = 0;
        int len = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);

            while (windows.get(c) > 1) {
                char b = s.charAt(left);
                left++;
                windows.put(b, windows.get(b) - 1);
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
