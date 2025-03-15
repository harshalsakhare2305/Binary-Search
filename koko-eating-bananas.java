//https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public boolean isPossible(int mid,int[]piles,int h){
        long total=0L;

        for(int i=0;i<piles.length;i++){
             total+= (int)(Math.ceil((double)piles[i]/mid));
            
        }
         System.out.println(total+" "+mid);

        return total<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
       int n=piles.length;
       int low =1;
       int high=Arrays.stream(piles).max().getAsInt();

       int ans=0;
       while(low<=high){
        int mid =low+(high-low)/2;

        if(isPossible(mid,piles,h)){
            ans=mid;
            high=mid-1;
        }else{
            low=mid+1;
        }
       }

       return low;
    }
}
