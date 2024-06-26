class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[2][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0) dp[0][j] = j;
                else if(j==0) dp[i%2][0] = i;
                else{
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i%2][j] = dp[(i-1)%2][j-1];
                    }
                    else{
                        int replace = dp[(i-1)%2][j-1];
                        int delete = dp[(i-1)%2][j];
                        int add = dp[i%2][j-1];
                        dp[i%2][j] =  Math.min(replace,Math.min(delete,add)) + 1;
                    }
                }
            }
        }
        return dp[n%2][m];
    }
   
}

