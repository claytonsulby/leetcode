import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> days1 = Arrays.asList(2, 3, 2);
        int k1 = 4;
        System.out.println("Test case 1: " + getMaximumPoints(days1, k1)); // Expected output: 8

        List<Integer> days2 = Arrays.asList(7, 4, 6, 3, 5);
        int k2 = 8;
        System.out.println("Test case 1: " + getMaximumPoints2(days2, k2)); // Expected output: 33
    }

    //chat gpt
    public static long getMaximumPoints(List<Integer> days, int k) {
        List<Integer> points = new ArrayList<>();
        
        // Convert the sprints into a points list
        for (int sprint : days) {
            for (int i = 1; i <= sprint; i++) {
                points.add(i);
            }
        }

        int n = points.size();

        // Calculate prefix sums
        long[] prefixSums = new long[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            prefixSums[i + 1] = prefixSums[i] + points.get(i % n);
        }

        // Find the maximum sum of k consecutive days
        long maxPoints = 0;
        for (int i = 0; i < n; i++) {
            long currentSum = prefixSums[i + k] - prefixSums[i];
            maxPoints = Math.max(maxPoints, currentSum);
        }

        return maxPoints;
    }

    //my solution
    public static long getMaximumPoints2(List<Integer> days, int k) {
        // Brute force approach

        List<Integer> tournament = new ArrayList<>();
        for (int sprint = 0; sprint < days.size(); sprint++) {
            for (int day = 1; day <= days.get(sprint); day++) {
                tournament.add(day);
            }
        }

        List<Long> pointSums = new ArrayList<>();
        for (int day = 0; day < tournament.size(); day++) {
            long points = 0;
            for (int offset = 0; offset < k; offset++) {
                if (day + offset < tournament.size()) {
                    points += tournament.get(day + offset);
                } else {
                    points += tournament.get((day + offset) % tournament.size());
                }
            }
            pointSums.add(points);
        }

        Collections.sort(pointSums);
        return pointSums.get(pointSums.size() - 1);
    }
}
