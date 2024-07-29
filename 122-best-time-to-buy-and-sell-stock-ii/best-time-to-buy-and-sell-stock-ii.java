class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row: dp) Arrays.fill(row,-1);
        return f(0,n,0,prices,dp);
    }
    public int f(int i, int n, int buy,int[] prices,int[][] dp){
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(i==n-1){
            if(buy==0) return dp[i][buy] = 0;
            return dp[i][buy] =  prices[n-1];
        }
        int ignore = f(i+1,n,buy,prices,dp);
        if(buy==0) {
            int buying = f(i+1,n,1,prices,dp) - prices[i];
            return  dp[i][buy] = Math.max(buying,ignore);
        }else{
            int selling = f(i+1,n,0,prices,dp) + prices[i];
            return  dp[i][buy] = Math.max(selling,ignore);
        }
    }
}