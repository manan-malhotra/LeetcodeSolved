class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int num:nums) arr.add(num);
        arr.add(1);
        int[][] dp = new int[n+2][n+2];
        for(int row[] : dp) Arrays.fill(row,-1);
        return f(1,n,arr,dp);
    }
    public int f(int i, int j, List<Integer> arr,int[][] dp){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i>j) return dp[i][j] = 0;
        if(i==j){
            return dp[i][j] = arr.get(i-1)*arr.get(i)*arr.get(i+1);
        }
        int maxi = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int total = f(i,k-1,arr,dp) + f(k+1,j,arr,dp) + (arr.get(i-1) * arr.get(k) * arr.get(j+1));
            maxi = Math.max(maxi,total);
        }
        return dp[i][j] = maxi;
    }
}