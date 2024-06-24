class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int n = coins.length - 1;
        int[][] dp = new int[n+1][amount+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int ans = coinChange(n,amount,coins,dp);
        if(ans>=(int) Math.pow(10, 9)) return -1;
        return ans;
    }
    public int coinChange(int i, int amount, int[] coins,int[][] dp){
        if(amount == 0) return dp[i][amount] = 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int notTake = (int) Math.pow(10, 9);
        int take = (int) Math.pow(10, 9);
        if(i>0) notTake = coinChange(i-1,amount,coins,dp);
        if(coins[i]<=amount) take = coinChange(i,amount-coins[i],coins,dp) + 1;
        return dp[i][amount] = Math.min(notTake,take);
    }
}


