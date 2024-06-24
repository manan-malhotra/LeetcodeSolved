class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0) dp[j] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                int notTake = dp[j];
                int take = dp[j-coins[i]];
                dp[j] = take + notTake;
            }
        }
        return dp[amount];
    }
    
}

