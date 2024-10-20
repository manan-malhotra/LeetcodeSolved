class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        int[][] dp = new int[m][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        return n + f(0,0,ring,key,m,n,dp);
    }
    public int f(int i,int j, String ring, String key, int m, int n, int[][] dp){
        if(j==n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=0;k<m;k++){
            if(key.charAt(j)==ring.charAt(k)){
                int count = Math.min(m-Math.abs(i-k),Math.abs(i-k));
                ans = Math.min(ans,count + f(k,j+1,ring,key,m,n,dp));
            }
        }
        return dp[i][j] = ans;
    }
}