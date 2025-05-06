package org.example.array;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SortColors {
    private static final Logger LOGGER = Logger.getLogger(SortColors.class.getName());

    // time complexity: O(n)
    // space complexity: O(1)
    private static  void sortColorsByThreePointer(int[] array) {
        int one = -1;
        int two = array.length;
        int i = 0;
        while (i < two) {
            if (array[i] == 0) {
                one++;
                int temp = array[one];
                array[one] = array[i];
                array[i] = temp;
                i++;
            } else if (array[i] == 2) {
                two--;
                int temp = array[two];
                array[two] = array[i];
                array[i] = temp;
            } else {
                i++;
            }
        }
    }

    // time complexity: O(n)
    // space complexity: O(1)
    private static void sortColors(int[] array) {
        int[] count = new int[3];
        for (int j : array) {
            count[j]++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            array[index++] = 0;
        }

        for (int i = 0; i < count[1]; i++) {
            array[index++] = 1;
        }

        for (int i = 0; i < count[2]; i++) {
            array[index++] = 2;
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {2, 0, 2, 1, 1, 0};
        sortColors(array1);
        for (int i : array1) {
            LOGGER.log(Level.INFO, "sortColors result {0}", String.valueOf(i));
        }
        LOGGER.log(Level.INFO, "--------Using three pointer approach--------");
        int[] array2 = new int[] {2, 0, 2, 1, 1, 0};
        sortColorsByThreePointer(array2);
        for (int i : array2) {
            LOGGER.log(Level.INFO, "sortColorsByThreePointer result {0}", String.valueOf(i));
        }
    }
}
