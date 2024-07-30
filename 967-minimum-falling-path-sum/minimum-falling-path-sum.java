class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, (int)1e9);
        for(int j = 0; j<n; j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(j!=0) dp[i][j] = dp[i-1][j-1];
                if(j!=n-1) dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                dp[i][j] += matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(dp[n-1][i],ans);
        }
        return ans;
    }
}