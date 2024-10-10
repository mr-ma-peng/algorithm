package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntersectionOfTwoArrays {

    private static final Logger LOGGER = Logger.getLogger(IntersectionOfTwoArrays.class.getName());

    private static Integer[] intersectionBySet(int[] nums1, int[] nums2) {
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

    private static Integer[] intersectionByMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, (map.get(num) - 1));
            }
        }
        return result.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Integer[] result = intersectionBySet(nums1, nums2);
        LOGGER.log(Level.INFO, "Intersection of two arrays: {0}", Arrays.toString(result));
        Integer[] intersectionByMap = intersectionByMap(nums1, nums2);
        LOGGER.log(Level.INFO, "Intersection of two arrays: {0}", Arrays.toString(intersectionByMap));
    }
}
