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
    
}



