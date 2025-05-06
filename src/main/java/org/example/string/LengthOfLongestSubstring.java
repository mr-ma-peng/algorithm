package org.example.string;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LengthOfLongestSubstring {

    private static final Logger LOGGER = Logger.getLogger(LengthOfLongestSubstring.class.getName());

    public static int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        LOGGER.log(Level.INFO, "Length of longest substring: {0}", result);
    }
}
