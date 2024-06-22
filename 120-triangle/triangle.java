class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int dp[][] = new int[2][m];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            m = triangle.get(i).size();
            for(int j=0;j<m;j++){
                if(j==0) dp[i%2][j] = dp[(i-1)%2][j];
                if(j!=0)dp[i%2][j] = dp[(i-1)%2][j-1];
                if(j!=m-1) dp[i%2][j]=Math.min(dp[i%2][j],dp[(i-1)%2][j]);
                dp[i%2][j] += triangle.get(i).get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        m = dp[0].length;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,dp[(n-1)%2][i]);
        }
        return ans;
    }
}