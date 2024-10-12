class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<n;i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return  Math.min(dp[n-1],dp[n-2]);
    }
    public int costMin(int start, int sum, int n, int[] cost){
        if(start+2>=n) return sum;
        return Math.min(costMin(start+1,sum+cost[start+1],n,cost) , costMin(start+2,sum+cost[start+2],n,cost));
    }
}