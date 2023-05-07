class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0 ;
        int profitToday = 0;
        int leastSoFar = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            leastSoFar = Math.min(leastSoFar,prices[i]); // What is the least price of stock so far
            profitToday = prices[i]-leastSoFar; // What would be the best Profit if we bought at leastSoFar and sold today @ i
            if(profitToday>maxProfit) maxProfit = profitToday; 
        }
        return maxProfit;
    }
}