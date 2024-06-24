class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return countChange(n-1,amount,coins,dp);
    }
    public int countChange(int i, int amount, int[] coins,int[][] dp){
        if(dp[i][amount] !=-1) return dp[i][amount] ;
        if(i==0){
            if(amount%coins[i]==0) return dp[i][amount] = 1;
            return dp[i][amount] = 0;
        }
        int notTake = countChange(i-1,amount,coins,dp);
        int take = 0;
        if(amount>=coins[i]) take = countChange(i,amount-coins[i],coins,dp);
        return dp[i][amount] = take + notTake;
    }
}

