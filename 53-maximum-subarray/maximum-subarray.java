class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int num:nums){
            curr+=num;
            max = Math.max(curr,max);
            curr = Math.max(curr,0);
        }
        return max;
    }
}