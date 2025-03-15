//https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
class Solution {
    public boolean isPossible(int mid, int[]nums,long k){
        long count=0;
        for(int i=0;i<nums.length;i++){
            count+=(nums[i]/mid);
        }

        return count>=k;
    }
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
         long sum=0;
        for(int i:candies){
            sum+=i;
        }

        if(k>sum)return 0;

        int low=1;
        int high=Arrays.stream(candies).max().getAsInt();

        int ans =0;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isPossible(mid,candies,k)){
             ans=mid;
             low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return ans;
    }
}
