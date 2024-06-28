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
}

