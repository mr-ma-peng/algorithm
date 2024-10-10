package org.example.array;

import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntersectionOfTwoArrays {

    private static final Logger LOGGER = Logger.getLogger(IntersectionOfTwoArrays.class.getName());

    private Integer[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new java.util.HashSet<>();
        Set<Integer> set2 = new java.util.HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        return set2.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Integer[] result = new IntersectionOfTwoArrays().intersection(nums1, nums2);
        LOGGER.log(Level.INFO, "Intersection of two arrays: {0}", Arrays.toString(result));
    }
}
