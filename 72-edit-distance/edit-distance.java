class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return count(n-1,m-1,n,m,s1,s2,dp);
    }
    public int count(int i,int j,int n,int m, String s1, String s2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = count(i-1,j-1,n,m,s1,s2,dp);
        }
        int replace = count(i-1,j-1,n,m,s1,s2,dp);
        int delete = count(i-1,j,n,m,s1,s2,dp);
        int add = count(i,j-1,n,m,s1,s2,dp);
        return dp[i][j] =  Math.min(replace,Math.min(delete,add)) + 1;
    }
}

