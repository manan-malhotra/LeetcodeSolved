class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                    int right = dp[i][j+1];
                    int down = down = dp[i+1][j];
                    dp[i][j] = Math.max(right,down);
                }
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


