class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return findMin(grid,m-1,n-1,dp);
    }
    public int findMin(int[][] grid, int m, int n,int[][] dp){
        if(dp[m][n]!=-1) return dp[m][n];
        else if(m==0 && n==0) dp[m][n] =  grid[m][n];
        else if(m==0) dp[m][n] =  grid[m][n]+findMin(grid,m,n-1,dp);
        else if(n==0) dp[m][n] =  grid[m][n]+findMin(grid,m-1,n,dp);
        else dp[m][n] = Math.min(findMin(grid,m-1,n,dp),findMin(grid,m,n-1,dp)) + grid[m][n];
        return dp[m][n];
    }
}

