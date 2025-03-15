import java.util.*;
//https://leetcode.com/problems/house-robber-iv/description/?envType=daily-question&envId=2025-03-15
class Solution {
    public boolean isPossible(int val, int k, int[] nums) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= val) {
                count++;
                i += 2; // Skip the adjacent element
            } else {
                i++;
            }
            if (count >= k) return true;
        }
        return false;
    }

    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, k, nums)) {
                ans = mid;
                high = mid - 1; // Try for a smaller capability
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
