package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public void moveZeroes(int[] nums) {
        int k = removeElement(nums, 0);
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public List<List<Integer>> twoSumTarget(int[] nums, Integer target, Integer start, Integer end) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int leftIndex = Objects.isNull(start) ? 0 : start;
        int rightIndex = Objects.isNull(end) ? nums.length - 1 : end;
        while (leftIndex < rightIndex) {
            int sum = nums[leftIndex] + nums[rightIndex];
            int left = nums[leftIndex];
            int right = nums[rightIndex];
            if (sum == target) {
                result.add(List.of(nums[leftIndex], nums[rightIndex]));
                while (leftIndex < rightIndex && nums[leftIndex] == left) leftIndex++;
                while (leftIndex < rightIndex && nums[rightIndex] == right) rightIndex--;
            } else if (sum < target) {
                while (leftIndex < rightIndex && nums[leftIndex] == left) leftIndex++;
            } else {
                while (leftIndex < rightIndex && nums[rightIndex] == right) rightIndex--;
            }
        }
        return result;
    }


    public List<List<Integer>> threeSumTarget(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, target - nums[i], i + 1, nums.length - 1);
            for (List<Integer> item : tuples) {
                List<Integer> newList = new ArrayList<>(item);
                newList.add(nums[i]);
                newList.sort(Integer::compareTo);
                result.add(newList);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }

        return result;
    }
}
