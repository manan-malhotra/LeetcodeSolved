class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[2][n];
        if(obstacleGrid[0][0]==1) return 0;
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==0) {
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int j=1;j<m;j++){
            for(int i=0;i<n;i++){
                if(obstacleGrid[j][i]==0) {
                    if(i==0) dp[j%2][i] = dp[(j-1)%2][i];
                    else dp[j%2][i] = dp[(j-1)%2][i] + dp[j%2][i-1];
                }else{
                    if(i==0) dp[j%2][i] = 0;
                    dp[j%2][i] = 0;
                }
            }
        }
        return dp[(m-1)%2][n-1];
    }
}