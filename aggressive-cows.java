//https://www.geeksforgeeks.org/problems/aggressive-cows/1
// User function Template for Java
class Solution {
    
    public static boolean isPossible(int mid,int[]stalls,int k){
        int st =stalls[0];
        
        int cows=1;
        for(int i=1;i<stalls.length;i++){
            if(Math.abs(stalls[i]-st)>=mid){
                cows++;
                st=stalls[i];
            }
            
            if(cows>=k)return true;
        }
        
        
        return false ;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        int n=stalls.length;
        int low =1;
        int max =Arrays.stream(stalls).max().getAsInt();
        int min =Arrays.stream(stalls).min().getAsInt();
        int high =max-min;
        int ans=-1;
        Arrays.sort(stalls);
        
        while(low<=high){
            int mid =low+(high-low)/2;
            
            if(isPossible(mid,stalls,k)){
                ans=mid;
                low=mid+1;
                
            }else{
                high=mid-1;
            }
        }
        
        return ans ;
    }
    
}
