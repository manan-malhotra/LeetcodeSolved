class Solution {
    public int maxProfit(int[] prices) {
        int maxPossible = 0;
        int leastPrice = Integer.MAX_VALUE ;
        int ifSoldToday = 0;
        for(int i:prices){
            if(i<leastPrice) leastPrice = i;
            ifSoldToday = i - leastPrice;
            if(ifSoldToday>maxPossible) maxPossible = ifSoldToday;
        }
        return maxPossible;
    }
}