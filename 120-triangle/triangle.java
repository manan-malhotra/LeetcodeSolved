class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int dp[][] = new int[n][m];
        for(int j=0;j<m;j++) dp[n-1][j] = triangle.get(n-1).get(j);
        for(int i=n-2;i>=0;i--){
            m = triangle.get(i).size();
            for(int j=0;j<m;j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
