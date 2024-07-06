class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for(int cardPoint : cardPoints) total+=cardPoint;
        if(n==k) return total;
        k = n-k;
        //Need to find n consecutive min number now;
        int mini = Integer.MAX_VALUE;
        int curr = 0;
        int i=0;
        int j=0;
        while(i!=n){
            curr+=cardPoints[i++];
            if((i)-j==k){
                mini = Math.min(curr,mini);
                curr-=cardPoints[j++];
            }
        }
        total-=mini;
        return total;
    }
}