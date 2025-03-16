//https://leetcode.com/problems/heaters/
class Solution {
    public boolean isPossible(int mid,int[]house,int[]heat){
        List<int[]> ls =new ArrayList<>();

        for(int i=0;i<heat.length;i++){
            int st=Math.max(heat[i]-mid,0);
            int en=Math.min(heat[i]+mid,(int)1e9);

            ls.add(new int[]{st,en});
        }


        int left=0;
        int right=0;
       

        while(left<house.length && right<heat.length){

            int st=ls.get(right)[0];
            int en=ls.get(right)[1];

            if(house[left]>=st && house[left]<=en){
                left++;
            }else{
                right++;
            }

            
        }

        if(left<house.length){
            return false;
        }

        return true;


    }
    public int findRadius(int[] houses, int[] heaters) {
        int low=0;
        int high=(int)1e9;
        int ans=-1;

        Arrays.sort(houses);
        Arrays.sort(heaters);

        while(low<=high){
            int mid =low+(high-low)/2;

            if(isPossible(mid,houses,heaters)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
}
