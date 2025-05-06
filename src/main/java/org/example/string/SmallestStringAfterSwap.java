package org.example.string;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SmallestStringAfterSwap {

    private static final Logger logger = Logger.getLogger(SmallestStringAfterSwap.class.getName());

    public static String getSmallestString(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int minIndex = -1;
        int swapIndex = -1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (charArray[j] < charArray[i] && (minIndex == -1 || charArray[j] < charArray[minIndex])) {
                        minIndex = j;
                        swapIndex = i;
                    }

            }
            if (minIndex != -1) {
                char temp = charArray[swapIndex];
                charArray[swapIndex] = charArray[minIndex];
                charArray[minIndex] = temp;
                break;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String s = "bcdac";
        logger.log(Level.INFO, "Smallest string after one swap: {0}", getSmallestString(s));
    }
}
