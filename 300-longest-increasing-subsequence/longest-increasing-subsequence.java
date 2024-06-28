class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return lengthOfLIS(1,0,nums,n,dp);
    }
    public int lengthOfLIS(int i, int j, int[] nums, int n,int[][] dp){
        if(i==n+1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int take = 0;
        if(j==0 || nums[i-1]>nums[j-1]){
            take = 1 + lengthOfLIS(i+1,i,nums,n,dp);
        }
        int notTake = lengthOfLIS(i+1,j,nums,n,dp);
        return dp[i][j] = Math.max(take,notTake);
    }
}

