class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int ans = dp[(i+1)][j];
                if(s.charAt(i)==t.charAt(j)){
                    if(j==m-1) ans+=1;
                    else ans+=dp[(i+1)][j+1];
                }
                dp[i][j]=ans;
            }
        }
       return dp[0][0];
    }
    
}


