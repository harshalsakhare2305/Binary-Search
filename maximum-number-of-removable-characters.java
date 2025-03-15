//https://leetcode.com/problems/maximum-number-of-removable-characters/
class Solution {
    public boolean isPossible(int mid,String s,String p,int[]nums){
        char[] chs=s.toCharArray();
        char[] chp=p.toCharArray();

        for(int i=0;i<=mid;i++){
            chs[nums[i]]='#';
        }

        int l=0;
        int r=0;

        while(l<s.length() && r<p.length()){
          
          while(l<s.length() && chs[l]=='#'){
            l++;
            continue;
            }

            if(l>=s.length())break;

          if(chs[l]==chp[r]){
            l++;
            r++;
          }else{
            l++;
          }
        }


        if(r<p.length()){
            return false;
        }

        return true;
    }
    public int maximumRemovals(String s, String p, int[] removable) {
        int n =removable.length;
        if(n==0){
            return 0;
        }
        int low =0;
        int high=n-1;

        int ans=0;

        while(low<=high){
            int mid =low+(high-low)/2;

            if(isPossible(mid,s,p,removable)){
                ans=mid+1;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return ans;
    }
}
