class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[2][n+2];
        for(int i=n;i>0;i--){
            for(int j=n-1;j>=0;j--){
                int take = 0;
                if(j==0 || nums[i-1]>nums[j-1]){
                    take = 1 + dp[(i+1)%2][i];
                }
                int notTake = dp[(i+1)%2][j];
                dp[i%2][j] = Math.max(take,notTake);
            }
        }
        return dp[1][0];
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

