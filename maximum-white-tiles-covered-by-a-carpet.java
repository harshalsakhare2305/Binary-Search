//https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/
class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                return a[0]-b[0];
            }
        });
        int n=tiles.length;

        int[] prefix =new int[tiles.length];
        prefix[0]=tiles[0][1]-tiles[0][0]+1;

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+tiles[i][1]-tiles[i][0]+1;
        }

        int ans=Integer.MIN_VALUE;

        
        for(int i=0;i<n;i++){
            int leftStart =tiles[i][0];
            int rightEnd=tiles[i][0]+carpetLen-1;

            int left =i;
            int right =i-1;
            int l=i;
            int r=n-1;

            while(l<=r){
                int mid = (l+r)/2;

                if(tiles[mid][1]<=rightEnd){
                    right=mid;
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }

           int curr=0;
            if(right!=(i-1)){
                curr+=prefix[right];

                if(left>0){
                    curr-=prefix[left-1];
                }
            }


            //for partially Covered tiles

          if(right+1<n){
              curr+=(Math.max(0,rightEnd-tiles[right+1][0]+1));
          }


            ans=Math.max(curr,ans);
        }

       return ans;
    }
}
