class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0) dp[i][j] = j;
                else if(j==0) dp[i][j] = i;
                else{
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        int replace = dp[i-1][j-1];
                        int delete = dp[i-1][j];
                        int add = dp[i][j-1];
                        dp[i][j] =  Math.min(replace,Math.min(delete,add)) + 1;
                    }
                }
            }
        }
        return dp[n][m];
    }
   
}

