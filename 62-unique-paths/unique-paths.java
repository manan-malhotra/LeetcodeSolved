class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n];
        dp[0][0] = 1;
        for(int i=1;i<n;i++){
            dp[0][i]=1;
        }
        for(int j=1;j<2;j++){
            dp[j][0]=1;
        }
        for(int j=1;j<m;j++){
            for(int i=1;i<n;i++){
                dp[j%2][i] = dp[(j-1)%2][i] + dp[j%2][i-1];
            }
        }
        return dp[(m-1)%2][n-1];
    }
}



