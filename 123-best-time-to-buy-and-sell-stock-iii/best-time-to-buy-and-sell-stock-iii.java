class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        dp[n-1][1][0] = prices[n-1];
        dp[n-1][1][1] = prices[n-1];
        for(int i=n-2;i>=0;i--){
            for(int isBought = 1;isBought>=0;isBought--){
                for(int timesSold = 1; timesSold>=0;timesSold--){
                    if(isBought==1){
                        int hold = dp[i+1][isBought][timesSold];
                        int sell = prices[i] + dp[i+1][0][timesSold+1];
                        dp[i][isBought][timesSold] = Math.max(sell,hold);
                    }else{
                        int buy =  dp[i+1][1][timesSold] - prices[i];
                        int ignore = dp[i+1][isBought][timesSold];
                        dp[i][isBought][timesSold] = Math.max(buy,ignore);
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}

