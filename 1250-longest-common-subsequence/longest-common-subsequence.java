class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[2][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int diagonal = text1.charAt(i)==text2.charAt(j)?1:0;
                int right = 0;
                int down = 0;
                if(i+1 < n && j+1<m) diagonal+=dp[(i+1)%2][j+1];
                if(i+1<n) down = dp[(i+1)%2][j];
                if(j+1<m) right = dp[i%2][j+1];
                dp[i%2][j] = Math.max(diagonal, Math.max(right,down));
            }
        }
        return dp[0][0];
    }
}



