class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);
        f(n-1,m-1,dp,grid);
        return dp[n-1][m-1];
    }
    public int f(int i, int j, int[][] dp, int[][] grid){
        if(dp[i][j]!=-1) return dp[i][j];
        if(grid[i][j]==1){
            return dp[i][j] = 0;
        }
        if(i==0 && j==0) return dp[i][j] = 1;
        if(i==0) return dp[i][j] = f(i,j-1,dp,grid);
        if(j==0) return dp[i][j] = f(i-1,j,dp,grid);
        return dp[i][j] = f(i,j-1,dp,grid) + f(i-1,j,dp,grid);
    }
}