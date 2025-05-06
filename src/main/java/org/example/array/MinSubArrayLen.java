package org.example.array;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MinSubArrayLen {

    private static final Logger LOGGER = Logger.getLogger(MinSubArrayLen.class.getName());

    // time complexity: O(n)
    // space complexity: O(1)
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < target) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }

            if (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 1, 2, 4, 3};
        int target = 7;
        LOGGER.log(Level.INFO, "Minimum subarray length: {0}", minSubArrayLen(target, nums));
    }
}
