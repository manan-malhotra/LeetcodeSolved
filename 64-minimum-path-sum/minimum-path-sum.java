class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                if(i==0 && j==0) {
                    dp[j][i] = grid[j][i]; 
                    continue;
                }
                if(j==0) {
                    dp[0][i] = dp[0][i-1] + grid[0][i]; 
                    continue;
                }
                if(i==0) {
                    dp[j%2][0] = dp[(j-1)%2][0] + grid[j][0]; 
                    continue;
                }
                dp[j%2][i] = Math.min(dp[(j-1)%2][i],dp[j%2][i-1]) + grid[j][i];
            }
        }
        return dp[(m-1)%2][n-1];
    }
}

