package org.example.array;

public class MountainPeaksCounter {

    public static void main(String[] args) {
        int[] map = {0, 1, 2, 4, 3, 1, 0, 0, 1, 2, 3, 1, 2, 1, 0};
        int numberOfPeaks = countPeaks(map);
        System.out.println(numberOfPeaks);
    }

    private static int countPeaks(int[] map) {
        int peaks = 0;
        int n = map.length;

        for (int i = 0; i < map.length; i++) {
            if (
                    (i == 0 && map[i] > map[i + 1]) ||
                            (i == n - 1 && map[i] > map[i - 1]) ||
                            (i > 0 && i < n - 1 && map[i] > map[i - 1] && map[i] < map[i + 1])) {
                peaks++;
            }
        }
        return peaks;
    }
}
