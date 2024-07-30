class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        return f(m-1,n-1,obstacleGrid,dp);
    }
    public int f(int i, int j, int[][] obstacleGrid,int[][] dp){
        if(dp[i][j]!=-1) return dp[i][j];
        if(obstacleGrid[i][j]==1) return dp[i][j] =  0;
        if(i==0 && j==0) return dp[i][j] = 1;
        if(i==0) return dp[i][j] = f(i,j-1,obstacleGrid,dp);
        if(j==0) return dp[i][j] = f(i-1,j,obstacleGrid,dp);
        return dp[i][j] = f(i-1,j,obstacleGrid,dp) + f(i,j-1,obstacleGrid,dp);
    }
}