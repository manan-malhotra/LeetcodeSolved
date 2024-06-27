class Solution {
    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        int[][] dp = new int[2][2];
        dp[1][(n-1)%2] = prices[n-1];
        for(int i=n-2;i>=0;i--){
            for(int isBought=1;isBought>=0;isBought--){
                if(isBought==1){
                    int sell = prices[i] + dp[0][(i+1)%2];
                    int hold = dp[1][(i+1)%2];
                    dp[1][i%2] = Math.max(sell,hold);
                }else{
                    int buy =  dp[1][(i+1)%2] - prices[i]-fee;
                    int ignore = dp[0][(i+1)%2];
                    dp[0][i%2] = Math.max(buy,ignore);
                }
            }
        }
        return dp[0][0];
    }
}
