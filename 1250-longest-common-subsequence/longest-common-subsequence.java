class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);
        return f(0,0,n,m,text1,text2,dp);
    }
    public int f(int i, int j, int n, int m, String text1, String text2,int[][] dp){
        if(i==n || j==m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int match = 0;
        if(text1.charAt(i)==text2.charAt(j)) return dp[i][j] =  1 + f(i+1,j+1,n,m,text1,text2,dp);
        int ignore = Math.max(f(i,j+1,n,m,text1,text2,dp),f(i+1,j,n,m,text1,text2,dp));
        return  dp[i][j] =  Math.max(match,ignore);
    }
}