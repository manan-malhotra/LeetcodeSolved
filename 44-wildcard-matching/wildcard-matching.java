class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return isMatch(n-1,m-1,s,p,dp);
    }
    public boolean isMatch(int i,int j, String s, String p,int[][] dp){
        if(i==-1 && j==-1) return true;
        if(i==-1) {
            if(p.charAt(j)=='*') return isMatch(i,j-1,s,p,dp);
            return false;
        }
        if(j==-1) return false;
        if(dp[i][j]!=-1) return dp[i][j]==1;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j)=='?'){
            if(isMatch(i-1,j-1,s,p,dp)) dp[i][j] =1;
            else dp[i][j]=0;
        }
        if(p.charAt(j)=='*'){
            if(isMatch(i-1,j-1,s,p,dp) || isMatch(i-1,j,s,p,dp) || isMatch(i,j-1,s,p,dp)) dp[i][j] =1;
            else dp[i][j]=0;
        }
        return dp[i][j]==1;
    }
}


