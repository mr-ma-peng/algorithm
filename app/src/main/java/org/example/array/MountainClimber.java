package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class MountainClimber {
    private static int calculateEnergy(int[] terrain, int start, int end) {
        int energy = 0;
        for (int i = start; i < end; i++) {
            int diff = terrain[i + 1] - terrain[i];
            if(diff > 0) {
                energy += 2 * diff;
            } else if (diff < 0) {
                energy -= diff;
            }
        }
        return energy;
    }

    private static List<Integer> findPeaks(int[] terrain) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < terrain.length - 1; i++) {
            if(terrain[i] > terrain[i - 1] && terrain[i] > terrain[i + 1]) {
                peaks.add(i);
            }
        }
        return peaks;
    }

    private static List<Integer> findGroundLevels(int[] terrain) {
        List<Integer> groundLevels = new ArrayList<>();
        for (int i = 0; i < terrain.length; i++) {
            if (terrain[i] == 0) {
                groundLevels.add(i);
            }
        }
        return groundLevels;
    }

    private static int countSafePeaks(int[] terrain) {
        List<Integer> peaks = findPeaks(terrain);
        List<Integer> groundLevels = findGroundLevels(terrain);

        int safePeaks = 0;

        for (int peak : peaks) {
            boolean isSafe = false;
            for (int start : groundLevels) {
                if (start >= peak) {
                    break;
                }
                for (int end : groundLevels) {
                    if(end <= peak) {
                        continue;
                    }
                    int totalEnergy = calculateEnergy(terrain, start, end);
                    if (totalEnergy < 999) {
                        isSafe = true;
                        break;
                    }
                }
                if (isSafe) {
                    break;
                }
            }
            if (isSafe) {
                safePeaks++;
            }
        }
        return safePeaks;
    }

    public static void main(String[] args) {
        int[] terrain = {0, 1, 2, 4, 3, 1, 0, 0, 1, 2, 3, 1, 2, 1, 0};
        int safePeakCount = countSafePeaks(terrain);
        System.out.println(safePeakCount);
    }

}
