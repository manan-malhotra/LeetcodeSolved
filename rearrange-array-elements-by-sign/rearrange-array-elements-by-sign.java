class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int p =0;
        int n =1;
        for(int i : nums){
            if(i>0){
                ans[p]=i;
                p+=2;
            }else{
                ans[n]=i;
                n+=2;
            }
        }
        
        return ans;
    }
}