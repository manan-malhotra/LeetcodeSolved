class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(s, 0, n , dp);
    }

    public int f(String s, int i, int n,int[] dp) {
        if (i >= n)
            return 1;
        if(dp[i]!=-1) return dp[i];
        if (s.charAt(i) == '0')
            return dp[i] = 0;
        int first = Character.getNumericValue(s.charAt(i));
        int second = -1;
        if (i + 1 < n)
            second = Character.getNumericValue(s.charAt(i + 1));
        if (second != -1) {
            int total = (first * 10) + second;
            if (total < 27) {
                return dp[i] = f(s, i + 1, n,dp) + f(s, i + 2, n,dp);
            }
        }
        return dp[i] = f(s, i + 1, n,dp);
    }
}