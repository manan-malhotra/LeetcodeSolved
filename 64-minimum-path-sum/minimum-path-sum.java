class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);
        dp[0][0] = grid[0][0];
        return f(grid,n-1,m-1,dp);
    }
    public int f(int[][] grid, int i, int j, int[][] dp){
        if(dp[i][j]!=-1) return dp[i][j];
        int num = grid[i][j];
        if(i==0 && j==0) return dp[i][j] = num;
        if(i==0) return dp[i][j] = num + f(grid,i,j-1,dp);
        if(j==0) return dp[i][j] = num + f(grid,i-1,j,dp);
        return dp[i][j] = num + Math.min(f(grid,i-1,j,dp), f(grid,i,j-1,dp));
    }
}