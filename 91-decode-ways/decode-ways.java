class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(s,n,0,dp);
    }
    public int f(String s, int n, int i,int[] dp){
        if(i==n) return 1;
        if(dp[i]!=-1) return dp[i];
        if(s.charAt(i)=='0') return dp[i] = 0;
        else{
            int first = s.charAt(i) - '0';
            int second = -1;
            if(i+1<n) second = s.charAt(i+1) - '0';
            if(second!=-1){
                int total = first*10 + second;
                System.out.println(total);
                if(total<27){
                    return dp[i] =  f(s,n,i+1,dp) + f(s,n,i+2,dp);
                }
            }
            return dp[i] =  f(s,n,i+1,dp);
        }
    }
}