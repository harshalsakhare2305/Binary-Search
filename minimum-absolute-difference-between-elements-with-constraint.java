//https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n=nums.size();

        TreeSet<Integer> st =new TreeSet<>();
        int min=Integer.MAX_VALUE;

        for(int i=x;i<nums.size();i++){
            st.add(nums.get(i-x));

            int ele =nums.get(i);
            Integer upper =st.ceiling(ele);
            Integer lower =st.floor(ele);


            if(upper!=null){
                min=Math.min(min,Math.abs(ele-upper));
            }
           
           if(lower!=null){
             min=Math.min(min,Math.abs(ele-lower));
           }


        }

        return min;
    }
}
