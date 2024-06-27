class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int [][] arr:dp){
            for(int[] arr2:arr) Arrays.fill(arr2,-1);
        }
        return maxProfit(0,0,0,prices,n-1,dp);
    }
    public int maxProfit(int i,int isBought, int timesSold,int[] prices, int n,int[][][]dp){
        if(dp[i][isBought][timesSold]!=-1) return dp[i][isBought][timesSold];
        if(timesSold == 2) return dp[i][isBought][timesSold] = 0;
        if(i==n){
            if(isBought==1) return dp[i][isBought][timesSold] = prices[i];
            return dp[i][isBought][timesSold] = 0;
        }
        if(isBought==1){
            int hold = maxProfit(i+1,isBought,timesSold,prices,n,dp);
            int sell = prices[i] + maxProfit(i+1,0,timesSold+1,prices,n,dp);
            return dp[i][isBought][timesSold] = Math.max(sell,hold);
        }
        int buy =  maxProfit(i+1,1,timesSold,prices,n,dp) - prices[i];
        int ignore = maxProfit(i+1,isBought,timesSold,prices,n,dp);
        return dp[i][isBought][timesSold] = Math.max(buy,ignore);
    }
}

