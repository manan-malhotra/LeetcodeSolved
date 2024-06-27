class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return maxProfit(0,0,prices,n-1,dp);
    }
    public int maxProfit(int i, int isBought, int[] prices, int n,int[][] dp){
        if(i>n) return 0;
        if(dp[isBought][i]!=-1) return dp[isBought][i];
        if(i==n){
            if(isBought==1) return dp[isBought][i] = prices[i];
            else return dp[isBought][i] = 0;
        }
        if(isBought==1){
            int sell = prices[i] + maxProfit(i+2,0,prices,n,dp);
            int hold = maxProfit(i+1,isBought,prices,n,dp);
            return dp[isBought][i] = Math.max(sell,hold);
        }else{
            int buy =  maxProfit(i+1,1,prices,n,dp) - prices[i];
            int ignore = maxProfit(i+1,isBought,prices,n,dp);
            return dp[isBought][i] = Math.max(buy,ignore);
        }
    }
}
