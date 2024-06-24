class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int diagonal = text1.charAt(i)==text2.charAt(j)?1:0;
                int right = 0;
                int down = 0;
                if(i+1 < n && j+1<m) diagonal+=dp[i+1][j+1];
                if(i+1<n) down = dp[i+1][j];
                if(j+1<m) right = dp[i][j+1];
                dp[i][j] = Math.max(diagonal, Math.max(right,down));
            }
        }
        return dp[0][0];
    }
    public int lcs(int i,int j,String text1,String text2, int n, int m,int[][] dp){
        if(i==n || j==m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = 0;
        if(text1.charAt(i)==text2.charAt(j)) ans = 1 + lcs(i+1,j+1,text1,text2,n,m,dp);
        return dp[i][j] = Math.max(ans,Math.max(lcs(i+1,j,text1,text2,n,m,dp),lcs(i,j+1,text1,text2,n,m,dp)));
    }
}



