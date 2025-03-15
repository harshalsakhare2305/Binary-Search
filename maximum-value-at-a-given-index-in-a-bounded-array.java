//https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
class Solution {
    int n;

    public boolean isPossible(int mid, int idx, int maxSum) {
        int left = idx;  // Elements on the left
        int right = n - idx - 1;  // Elements on the right

        long totalSum = (long) mid * (mid + 1) / 2;  // Sum of first `mid` natural numbers

        long leftSum, rightSum;

        // Left side handling
        if (left >= mid - 1) {
            leftSum = (long) (mid - 1) * mid / 2; // Sum of first (mid-1) natural numbers
            long extraLeft = left - (mid - 1); // Extra elements beyond (mid-1)
            if (extraLeft > 0) leftSum += extraLeft;
        } else {
            long miss = mid - 1 - left;
            if (miss < 0) miss = 0;
            long missSum = (long) miss * (miss + 1) / 2;
            leftSum = totalSum - mid - missSum;
        }

        // Right side handling
        if (right >= mid - 1) {
            rightSum = (long) (mid - 1) * mid / 2;
            long extraRight = right - (mid - 1);
            if (extraRight > 0) rightSum += extraRight;
        } else {
            long miss = mid - 1 - right;
            if (miss < 0) miss = 0;
            long missSum = (long) miss * (miss + 1) / 2;
            rightSum = totalSum - mid - missSum;
        }

        // Total sum check
        long sum = leftSum + rightSum + mid;
        return sum <= maxSum;
    }

    public int maxValue(int m, int index, int maxSum) {
        n = m;
        int low = 1, high = maxSum, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, index, maxSum)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
