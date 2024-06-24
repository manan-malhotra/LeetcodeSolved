class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake = dp[i-1][j];
                int take = (int) Math.pow(10, 9);
                if(coins[i]<=j) take = dp[i][j-coins[i]] + 1;
                dp[i][j] = Math.min(notTake,take);
            }
        }
        int ans = dp[n-1][amount];
        if(ans>=(int)Math.pow(10,9)) return -1;
        return ans;
    }
}


