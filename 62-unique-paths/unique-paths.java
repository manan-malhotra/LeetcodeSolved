class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        return f(m-1,n-1,dp);
    }
    public int f(int i, int j,int[][] dp){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==0 || j==0) return dp[i][j] = 1;
        return dp[i][j] = f(i-1,j,dp) + f(i,j-1,dp);
    }
}