class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) Arrays.fill(row,(int)1e9);
        for(int i=0;i<n;i++){
            for(int j=0; j<=amount;j++){
                if(i==0){
                    if(j%coins[0]==0) dp[0][j] = j/coins[0];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                    if(coins[i]<=j) dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j-coins[i]]);
                }
            }
        }
        return dp[n-1][amount]==(int)1e9?-1:dp[n-1][amount];
    }
}