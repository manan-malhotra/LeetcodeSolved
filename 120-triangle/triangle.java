class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int dp[][] = new int[n][m];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            m = triangle.get(i).size();
            for(int j=0;j<m;j++){
                if(j==0) dp[i][j] = dp[i-1][j];
                if(j!=0)dp[i][j] = dp[i-1][j-1];
                if(j!=m-1) dp[i][j]=Math.min(dp[i][j],dp[i-1][j]);
                dp[i][j] += triangle.get(i).get(j);
                System.out.print(dp[i][j]+" "+m);
            }
            System.out.println(" ");
        }
        int ans = Integer.MAX_VALUE;
        m = dp[0].length;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}