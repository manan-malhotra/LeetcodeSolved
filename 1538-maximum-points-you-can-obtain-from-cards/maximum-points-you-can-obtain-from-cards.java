class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalScore = 0;
        for(int i:cardPoints) totalScore+=i;
        int n = cardPoints.length;
        if(n==k) return totalScore;
        k=n-k;
        int i=0,j=0;
        int minSubArray = totalScore;
        int sum = 0;
        while(j!=n){
            sum+=cardPoints[j];
            if(j-i+1==k){
                minSubArray = Math.min(minSubArray,sum);
                sum-=cardPoints[i];
                i++;
            }
            j++;
        }
        // System.out.println()
        return totalScore-minSubArray;
    }
}