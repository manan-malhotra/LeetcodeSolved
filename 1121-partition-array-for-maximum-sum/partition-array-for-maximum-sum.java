class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        int[][] max = new int[n][n+1];
        for(int[] row:max) Arrays.fill(row,-1);
        for(int i=0;i<n;i++){
            max[i][i] = arr[i];
        }
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int maxCost = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(j>=n) continue;
                int cost = (findMax(i,j+1,arr,max)*(j+1-i)) + dp[j+1];
                maxCost = Math.max(cost,maxCost);
            }
            dp[i] = maxCost;
        }
        return dp[0];
    }
    public int findMax(int i,int j,int[] arr,int[][] max){
        if(max[i][j]!=-1) return max[i][j];
        int currMax = 0;
        for(int num=i;num<j;num++){
            currMax = Math.max(currMax,arr[num]);
        }
        return max[i][j] = currMax;
    }
}