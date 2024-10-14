class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int num:nums) arr.add(num);
        arr.add(1);
        int n = arr.size();
        int[][] dp = new int[n][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        return f(1,n-2,arr,dp);
    }
    public int f(int i, int j, List<Integer> arr, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]>=0) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int cost = arr.get(i-1)*arr.get(j+1)*arr.get(k); 
            cost+=f(i,k-1,arr,dp) + f(k+1,j,arr,dp);
            maxi = Math.max(cost,maxi);
        }
        return dp[i][j] = maxi;
    }
}