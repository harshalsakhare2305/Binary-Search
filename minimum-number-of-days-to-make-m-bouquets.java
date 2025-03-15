//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
class Solution {
    public boolean isPossible(int mid,int[]nums,int k,int m){
        int count=0;
        int temp=k;

        for(int i=0;i<nums.length;i++){
            if(mid>=nums[i]){
                temp--;
                if(temp==0){
                    count++;
                    temp=k;
                }
            }else{
                temp=k;
            }
        }

        return count>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;

        int low=Arrays.stream(bloomDay).min().getAsInt();
        int high =Arrays.stream(bloomDay).max().getAsInt();
        int ans=-1;

        while(low<=high){
            int mid =low+(high-low)/2;

            if(isPossible(mid,bloomDay,k,m)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
}
