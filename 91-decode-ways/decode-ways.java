class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int n = s.length();
        int[] dp = new int[3];
        dp[n%3] = 1;
        dp[(n-1)%3] = s.charAt(n-1)=='0'?0:1;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)=='0') {
                dp[i%3] = 0;
                continue;
            }else{
                int first = s.charAt(i)-'0';
                int second = s.charAt(i+1)-'0';
                int total = first*10 + second;
                dp[i%3] = 0;
                if(total<27) dp[i%3]+= dp[(i+2)%3];
                dp[i%3] += dp[(i+1)%3];
            }
        }
        return dp[0];
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