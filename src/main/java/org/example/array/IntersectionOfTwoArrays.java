package org.example.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public Integer[] intersectionBySet(int[] nums1, int[] nums2) {
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

    public Integer[] intersectionByMap(int[] nums1, int[] nums2) {
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
}
