class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp)
        Arrays.fill(row,-1);
        return f(n-1,m-1,text1,text2,dp);
    }
    public int f(int i, int j, String text1, String text2,int[][] dp){
        if(i==-1 || j==-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int match = text1.charAt(i) == text2.charAt(j)?1:0;
        if(match == 1) return dp[i][j] = 1 + f(i-1,j-1,text1,text2,dp);
        return dp[i][j] = Math.max(f(i-1,j,text1,text2,dp), f(i,j-1,text1,text2,dp));
    }
}