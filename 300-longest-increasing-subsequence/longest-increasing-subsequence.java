class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int lis = 1;
        for(int i=1;i < n; i++){
            int currMax = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) currMax = Math.max(currMax,dp[j]);
            }
            dp[i] = currMax+1;
            lis = Math.max(dp[i],lis);
        }
        return lis;
    }
}