class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+2][n+1];
        for(int i=n;i>0;i--){
            for(int j=i-1;j>=0;j--){
                int take = 0;
                if(j==0 || nums[i-1]>nums[j-1]){
                    take = 1 + dp[i+1][i];
                }
                int notTake = dp[i+1][j];
                dp[i][j] = Math.max(take,notTake);
            }
        }
        return dp[1][0];
    }
}

