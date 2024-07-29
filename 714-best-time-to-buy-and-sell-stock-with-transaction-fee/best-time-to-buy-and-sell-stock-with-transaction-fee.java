class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int[] row : dp) Arrays.fill(row,-1);
        return f(0,0,n,prices,dp,fee);
    }
    public int f(int i, int isBought, int n, int[] prices,int[][] dp,int fee){
        if(i>=n) return 0;
        if(dp[i][isBought]!=-1) return dp[i][isBought];
        if(i==n-1){
            if(isBought==1) return dp[i][isBought] = prices[i];
            else return dp[i][isBought] = 0;
        }
        int ignore = f(i+1,isBought,n,prices,dp,fee);
        if(isBought==1){
            int sell = f(i+1,0,n,prices,dp,fee) + prices[i];
            return dp[i][isBought] = Math.max(sell,ignore);
        }
        int buy = f(i+1,1,n,prices,dp,fee) - prices[i] - fee;
        return dp[i][isBought] = Math.max(buy,ignore);
    }
}