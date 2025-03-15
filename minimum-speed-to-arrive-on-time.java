//https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
class Solution {
    public boolean isPossible(int mid,int[]dist,double hour){
        double total=0.0;

        for(int i=0;i<dist.length;i++){
            if(i==dist.length-1){
                total+=((double)dist[i]/mid);
            }else{
             total+=(dist[i]+mid-1)/(mid);
            }
            

            if(total>hour)return false;
        }


        return true;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int n =dist.length;
        int low=1;
        int high =(int)1e7;

        int ans =-1;
        while(low<=high){
            int mid =low+(high-low)/2;

            if(isPossible(mid,dist,hour)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
}
