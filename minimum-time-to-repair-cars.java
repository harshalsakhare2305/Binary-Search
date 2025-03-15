//https://leetcode.com/problems/minimum-time-to-repair-cars/
class Solution {
    public boolean isPossible(long mid,int[] ranks,int h){
        int cars=0;
        for(int i=0;i<ranks.length;i++){
            cars+=(Math.sqrt(mid/ranks[i]));
        }
        return cars>=h;
    }
    public long repairCars(int[] ranks, int cars) {
        int n =ranks.length;
        long low =1;
        long high=(long)1e14;

        long ans= -1;

        while(low<=high){
            long mid =low+(high-low)/2;

            if(isPossible(mid,ranks,cars)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
}
