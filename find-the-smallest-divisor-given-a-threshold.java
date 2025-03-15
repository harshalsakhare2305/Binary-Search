//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

/*Understanding the Problem

Given an array nums[], we need to find the smallest integer d (divisor) such that:
∑
𝑖
=
0
𝑛
−
1
⌈
𝑛
𝑢
𝑚
𝑠
[
𝑖
]
𝑑
⌉
≤
threshold
i=0
∑
n−1
​
 ⌈ 
d
nums[i]
​
 ⌉≤threshold
The division result for each element must be rounded up.
Binary Search on the Divisor

The divisor (d) can range from 1 (smallest possible divisor) to max(nums[]) (largest possible divisor).
We use binary search to efficiently find the smallest valid divisor.
Binary Search Initialization

low = 1 (smallest possible divisor)
high = max(nums[]) (largest possible divisor)
The answer must lie within this range.
Binary Search Execution

Compute mid = (low + high) / 2, which is a potential divisor.
Use the helper function isPossible(mid, nums, threshold) to check if mid is a valid divisor:
Iterate through nums[], compute the sum of ceil(nums[i] / mid).
If the total sum is less than or equal to threshold, then mid is a possible solution, so move high = mid - 1 to find a smaller divisor.
Otherwise, increase low = mid + 1 to try larger divisors.
Returning the Result

When the binary search ends, low will hold the smallest valid divisor.
Time Complexity Analysis
Binary Search Range: O(log max(nums))
Checking a Possible Divisor: O(n)
Total Complexity: 
𝑂
(
𝑛
log
⁡
(
max
⁡
(
𝑛
𝑢
𝑚
𝑠
)
)
)
O(nlog(max(nums))) */
class Solution {
    public boolean isPossible(int mid,int[]nums,int h){
        int result=0;

        for(int i=0;i<nums.length;i++){
            result+=(nums[i]+mid-1)/mid;
        }

        return result<=h;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int low =1;
        int high =Arrays.stream(nums).max().getAsInt();

        while(low<=high){
            int mid =low+(high-low)/2;

            if(isPossible(mid,nums,threshold)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low;
    }
}
