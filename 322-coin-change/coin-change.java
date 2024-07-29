class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0) dp[0][j] = j/coins[0];
            else dp[0][j] = (int)1e9;
        }
        for(int i=1; i<n; i++){
            for(int j=0;j<=amount;j++){
                int take = (int)1e9;
                int notTake = dp[i-1][j];
                if(j>=coins[i]) take = dp[i][j-coins[i]] + 1;
                dp[i][j] = Math.min(take,notTake);
            }
        }
        return dp[n-1][amount]==(int)1e9?-1:dp[n-1][amount];
    }
}