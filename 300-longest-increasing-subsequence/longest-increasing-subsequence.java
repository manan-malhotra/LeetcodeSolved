class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+2][n+1];
        for(int i=n;i>0;i--){
            for(int prev = i-1; prev>=0; prev--){
                int take = 0;
                if(prev == 0 || nums[i-1]>nums[prev-1]){
                    take = 1 + dp[i+1][i];
                }
                int notTake = dp[i+1][prev];
                dp[i][prev] =  Math.max(take,notTake);
            }
        }
        return dp[1][0];
        // return f(1,0,n,nums,dp);
    }
    public int f(int i, int prev, int n, int[] nums,int[][] dp){
        if(i==n+1) return 0;
        if(dp[i][prev]!=-1) return dp[i][prev];
        int take = 0;
        if(prev == 0 || nums[i-1]>nums[prev-1]){
            take = 1 + f(i+1,i,n,nums,dp);
        }
        int notTake = f(i+1,prev,n,nums,dp);
        return dp[i][prev] =  Math.max(take,notTake);
    }
}