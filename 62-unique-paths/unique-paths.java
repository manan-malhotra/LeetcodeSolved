class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return uniquePaths(m-1, n-1, dp);
    }

    public int uniquePaths(int m,int n, int[][]dp){
        if(m<0 || n<0) return 0;
        else if(dp[m][n]!=-1) return dp[m][n];
        else if(m==0 && n==0) {
            dp[m][n]=1;
        }else{
            dp[m][n] = uniquePaths(m-1,n,dp) + uniquePaths(m,n-1,dp);
        }return dp[m][n];
}}