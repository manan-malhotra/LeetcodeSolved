class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return match(0,0,s,t,n,m,dp);
    }
    public int match(int i,int j,String s, String t,int n, int m,int[][] dp){
        if(i==n || j==m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = 0;
        if(s.charAt(i)==t.charAt(j)){
            if(j==m-1) ans+=1;
            else ans+=match(i+1,j+1,s,t,n,m,dp);
        } 
        ans+=match(i+1,j,s,t,n,m,dp);
        return dp[i][j] = ans;
    }
}