//https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
class Solution {
    int[][] prefix;
    public boolean isPossible(int mid,int[][]mat,int m,int n,int h){
         
         for(int i=0;i+mid-1<m;i++){
            for(int j=0;j+mid-1<n;j++){
                int area=0;
               int leftcol=j;
                int rightcol=j+mid-1;

                int toprow=i;
                int btrow=i+mid-1;

                for(int k=toprow;k<=btrow;k++){
                    area+=(prefix[k][rightcol]-(leftcol-1>=0?(prefix[k][leftcol-1]):0));
                }
                 
                 if(area<=h)return true;

                
            }
         }

         return false;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;

      prefix =new int[m][n];

        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=mat[i][j];
              prefix[i][j]=sum;
            }
        }

        int low=1;
        int high =Math.min(m,n);

        int ans=0;
        while(low<=high){
            int mid =low+(high-low)/2;
           
           if(isPossible(mid,mat,m,n,threshold)){
            ans=mid;
            low=mid+1;
           }else{
            high=mid-1;
           }
            
        }

        return ans;
    }
}
