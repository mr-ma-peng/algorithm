package org.example.string;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LongestEvenO {

    private static final Logger logger = Logger.getLogger(LongestEvenO.class.getName());

    public static int longestEvenO(String s) {
        int n = s.length();
        String extended = s + s;
        int[] prefix = new int[2 * n + 1];
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        firstOccurrence.put(0, 0);
        int maxLen = 0;

        for (int i = 1; i < 2 * n; i++) {
            prefix[i] = prefix[i - 1] + (extended.charAt(i - 1) == 'o' ? 1 : 0);
            int mod = prefix[i] % 2;
            if (firstOccurrence.containsKey(mod)) {
                int length = i - firstOccurrence.get(mod);
                if (length <= n) {
                    maxLen = Math.max(maxLen, length);
                }
            } else {
                firstOccurrence.put(mod, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "oooxxox";
        logger.log(Level.INFO, "Longest even length substring with equal number of 0s and 1s: {0}", longestEvenO(s));
    }
}
