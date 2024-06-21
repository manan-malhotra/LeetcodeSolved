class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        f(n,dp);
        return dp[n];
    }
    public int f(int n, int[] dp){
        if(n<2) dp[n] = n;
        else if(dp[n]==-1){
            dp[n] = f(n-1,dp) + f(n-2,dp);
        }
        return dp[n];
    }
}