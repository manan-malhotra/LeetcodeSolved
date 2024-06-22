class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0]==1) return 0;
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==0) {
                dp[0][i] = dp[0][i-1];
            }
        }
        if(m==1) return dp[0][n-1];
        for(int j=1;j<m;j++){
            if(obstacleGrid[j][0]==0) {
                dp[j][0] = dp[j-1][0];
            }
        }
        for(int j=1;j<m;j++){
            for(int i=1;i<n;i++){
                if(obstacleGrid[j][i]==0) {
                    dp[j][i] = dp[(j-1)][i] + dp[j][i-1];
                }
            }
        }
        return dp[(m-1)][n-1];
    }
}