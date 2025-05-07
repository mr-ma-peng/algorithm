package org.example.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
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
