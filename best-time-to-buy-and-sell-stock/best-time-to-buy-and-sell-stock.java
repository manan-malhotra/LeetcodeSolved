class Solution {
    public int maxProfit(int[] prices) {
        int maxTotal = 0;
        int maxIfSold = 0;
        int leastPrice = Integer.MAX_VALUE;
        for(int i:prices){
            if(i<leastPrice) leastPrice = i;
            maxIfSold = i - leastPrice;
            if(maxIfSold>maxTotal) maxTotal=maxIfSold;
        }
        return maxTotal;
    }
}