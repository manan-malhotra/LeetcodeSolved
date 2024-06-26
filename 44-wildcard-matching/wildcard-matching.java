class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 && j==0) dp[0][0] = true;
                else if(i==0){
                    if(p.charAt(j-1)=='*') dp[0][j] = dp[0][j-1];
                }
                else if(j==0) dp[i%2][0] = false;
                else if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i%2][j] = dp[(i-1)%2][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                     dp[i%2][j] = dp[(i-1)%2][j-1] || dp[(i-1)%2][j] || dp[i%2][j-1];
                }
                else dp[i%2][j]=false;
            }
        }
        return dp[n%2][m];
    }
}




