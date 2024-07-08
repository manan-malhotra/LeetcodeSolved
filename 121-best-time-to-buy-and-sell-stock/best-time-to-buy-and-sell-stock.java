class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int leastPrice = Integer.MAX_VALUE;
        int ifSoldToday = 0;
        for(int price: prices){
            leastPrice = Math.min(leastPrice,price);
            ifSoldToday = price - leastPrice;
            totalProfit = Math.max(totalProfit,ifSoldToday);
        }
        return totalProfit;
    }
}