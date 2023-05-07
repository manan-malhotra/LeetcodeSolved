class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0 ;
        int profitToday = 0;
        int leastSoFar = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
          profitToday = prices[i]-leastSoFar;
          if(profitToday>maxProfit) maxProfit = profitToday;
          leastSoFar = Math.min(leastSoFar,prices[i]);
          //System.out.println("Least:"+leastSoFar+" profitToday"+profitToday);
        }
        return maxProfit;
    }
}