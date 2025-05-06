package org.example.array;

public class MinSubArrayLen {

    // time complexity: O(n)
    // space complexity: O(1)
    public int minSubArrayLen(int target, int[] nums) {
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
}
