class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[2][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i%2][j] = 1 + dp[(i+1)%2][j+1];
                } else{
                    int right = dp[i%2][j+1];
                    int down = down = dp[(i+1)%2][j];
                    dp[i%2][j] = Math.max(right,down);
                }
            }
        }
        return dp[0][0];
    }
}



