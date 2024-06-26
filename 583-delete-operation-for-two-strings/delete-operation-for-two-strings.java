class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int lcs = longestCommonSubsequence(word1,word2,n,m);
        return n+m-(2*lcs);
    }
    public int longestCommonSubsequence(String text1, String text2,int n,int m) {
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