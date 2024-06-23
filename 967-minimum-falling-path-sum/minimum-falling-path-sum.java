class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[2][n];
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int topLeft = Integer.MAX_VALUE;
                if(j!=0) topLeft = dp[(i-1)%2][j-1];
                int top = dp[(i-1)%2][j];
                int topRight = Integer.MAX_VALUE;
                if(j!=n-1) topRight = dp[(i-1)%2][j+1];
                dp[i%2][j] = matrix[i][j] + Math.min(top,Math.min(topLeft,topRight));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans = Math.min(ans,dp[(n-1)%2][j]);
        }
        return ans;
    }
}



