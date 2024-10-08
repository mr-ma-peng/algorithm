package org.example.search;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearch {

    private static final Logger LOGGER = Logger.getLogger(BinarySearch.class.getName());

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 4, 5, 7, 11, 15, 17, 22, 45};
        int target = 7;
        LOGGER.log(Level.INFO, "Index of target: {0}", binarySearch(array, target));
    }
}
