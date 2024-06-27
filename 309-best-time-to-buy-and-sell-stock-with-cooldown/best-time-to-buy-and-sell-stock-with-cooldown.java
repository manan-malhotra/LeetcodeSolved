class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[n-1][1] = prices[n-1];
        for(int i=n-2;i>=0;i--){
            for(int isBought=1; isBought>=0;isBought--){
                if(isBought==1){
                    int sell = prices[i] ;
                    if(i+2<n)sell += dp[i+2][0];
                    int hold = dp[i+1][isBought];
                     dp[i][isBought] = Math.max(sell,hold);
                }else{
                    int buy =  dp[i+1][1] - prices[i];
                    int ignore = dp[i+1][isBought];
                     dp[i][isBought] = Math.max(buy,ignore);
                }
            }
        }
        return dp[0][0];
    }
}


