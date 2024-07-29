class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] arr: dp){
            for(int[] row:arr) Arrays.fill(row,-1);
        }
        return f(0,0,k,n,prices,dp);
    }
    public int f(int i, int bought, int left, int n, int[] prices, int[][][] dp){
        if(dp[i][bought][left]!=-1) return dp[i][bought][left];
        if(left==0) return dp[i][bought][left] = 0;
        if(i==n-1){
            if(bought==1) return dp[i][bought][left] = prices[i];
            else return dp[i][bought][left] = 0;
        }
        int ignore = f(i+1,bought,left,n,prices,dp);
        if(bought==1){
            int sell = f(i+1,0,left-1,n,prices,dp) + prices[i];
            return dp[i][bought][left] = Math.max(sell,ignore);
        }
        int buy = f(i+1,1,left,n,prices,dp) - prices[i];
        return dp[i][bought][left] = Math.max(buy,ignore);
    }
}