class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n];
        dp[1][n-1] = prices[n-1];
        for(int i=n-2;i>=0;i--){
            for(int isBought=1;isBought>=0;isBought--){
                if(isBought==1){
                    int sell = prices[i] + dp[0][i+1];
                    int hold = dp[1][i+1];
                    dp[1][i] = Math.max(sell,hold);
                }else{
                    int buy =  dp[1][i+1] - prices[i];
                    int ignore = dp[0][i+1];
                    dp[0][i] = Math.max(buy,ignore);
                }
            }
        }
        return dp[0][0];
    }
    public int maxProfit(int i, int isBought, int[] prices, int n,int[][] dp){
        if(dp[isBought][i]!=-1) return dp[isBought][i];
        if(i==n){
            if(isBought==1) return dp[isBought][i] = prices[i];
            else return dp[isBought][i] = 0;
        }
        if(isBought==1){
            int sell = prices[i] + maxProfit(i+1,0,prices,n,dp);
            int hold = maxProfit(i+1,isBought,prices,n,dp);
            return dp[isBought][i] = Math.max(sell,hold);
        }else{
            int buy =  maxProfit(i+1,1,prices,n,dp) - prices[i];
            int ignore = maxProfit(i+1,isBought,prices,n,dp);
            return dp[isBought][i] = Math.max(buy,ignore);
        }
    }
}

