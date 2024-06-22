class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=1;i<n;i++){
            dp[0][i]=1;
        }
        for(int j=1;j<m;j++){
            dp[j][0]=1;
        }
        for(int j=1;j<m;j++){
            for(int i=1;i<n;i++){
                dp[j][i] = dp[j-1][i] + dp[j][i-1];
            }
        }
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                System.out.print(dp[j][i]+" ");
            }
            System.out.println();
        }
        return dp[m-1][n-1];
    }
}



