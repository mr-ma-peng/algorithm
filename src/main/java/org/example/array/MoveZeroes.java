package org.example.array;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoveZeroes {

    private static final Logger logger = Logger.getLogger(MoveZeroes.class.getName());

    private static int[] moveZeroesByTwoPointer(int[] array) {
        int slow = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                if (slow == i) {
                    slow++;
                    continue;
                }
                int temp = array[slow];
                array[slow] = array[i];
                array[i] = temp;
                slow++;
            }
        }
        return array;
    }


    private static int[] moveZeroes(int[] array) {
        int target = 0;
        int index = 0;
        int[] result = new int[array.length];
        for (int element : array) {
            if (element != target) {
                result[index] = element;
                index++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        logger.log(Level.INFO, "--------Using  traditional methods--------");
        int [] array1 = {0, 1, 0, 3, 12};
        Arrays.stream(moveZeroes(array1)).forEach(
            value -> logger.log(Level.INFO, String.valueOf(value))
        );
        logger.log(Level.INFO, "--------Using two pointer approach--------");
        int [] array2 = {0, 1, 0, 3, 12};
        Arrays.stream(moveZeroesByTwoPointer(array2)).forEach(
            value -> logger.log(Level.INFO, String.valueOf(value))
        );
    }

}
