class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int ifSoldToday = 0;
        int least = Integer.MAX_VALUE;
        for(int price : prices){
            if(price<least) least = price;
            ifSoldToday = price - least; 
            if(profit<ifSoldToday) profit = ifSoldToday;
            System.out.println(profit+" "+ifSoldToday+" "+price+" "+least);
        }
        return profit;
    }
}