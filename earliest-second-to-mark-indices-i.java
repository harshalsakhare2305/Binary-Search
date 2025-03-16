//https://leetcode.com/problems/earliest-second-to-mark-indices-i/

//Notes:=> https://github.com/MAZHARMIK/Interview_DS_Algo/blob/master/iPad%20PDF%20Notes/Leetcode-3048-Earliest%20Second%20to%20Mark%20Indices%20I.pdf
import java.util.*;

class Solution {
    public boolean isPossible(int mid, int[] nums, int[] change, int m, int n) {
        List<int[]> occurrences = new ArrayList<>();

        // Store last occurrence of each index in `change[]`
        int[] lastMarked = new int[n];
        Arrays.fill(lastMarked, -1);

        for (int i = 0; i <= mid; i++) {
            lastMarked[change[i] - 1] = i; // Convert 1-based to 0-based index
        }

        // Create a list of {lastOccurrence, index} pairs
        for (int i = 0; i < n; i++) {
            if (lastMarked[i] == -1) return false; // Some indices were never marked
            occurrences.add(new int[]{lastMarked[i], i});
        }

        // Sort based on last occurrence time
        occurrences.sort(Comparator.comparingInt(a -> a[0]));

        int time = 0;

        for (int[] pair : occurrences) {
            int lastOccurrence = pair[0];
            int index = pair[1];
            int requiredTime = nums[index] + 1;

            if (requiredTime+time-1 > lastOccurrence) {
                return false;
            }

            time +=requiredTime;
        }

        return true;
    }

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;
        int low = 0, high = m - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, nums, changeIndices, m, n)) {
                ans = mid + 1; // Convert 0-based to 1-based time
                high = mid - 1; // Try to minimize time
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
