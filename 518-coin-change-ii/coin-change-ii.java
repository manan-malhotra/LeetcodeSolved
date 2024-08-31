class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[2][amount+1];
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0) dp[0][j] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i%2][j] = dp[(i-1)%2][j];
                if(j>=coins[i]) dp[i%2][j] += dp[i%2][j-coins[i]];
            }
        }
        return dp[(n-1)%2][amount];
    }
}