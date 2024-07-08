class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int leastPrice = Integer.MAX_VALUE;
        int ifSoldToday = 0;
        for(int price: prices){
            if(price<leastPrice) leastPrice = price;
            ifSoldToday = price - leastPrice;
            if(ifSoldToday> totalProfit) totalProfit = ifSoldToday;
        }
        return totalProfit;
    }
}