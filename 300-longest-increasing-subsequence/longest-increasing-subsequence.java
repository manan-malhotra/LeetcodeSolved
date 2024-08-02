class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return f(1,0,n,nums,dp);
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