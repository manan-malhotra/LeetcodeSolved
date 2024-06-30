class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int maxCost = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(j>=n) continue;
                int cost = (findMax(i,j+1,arr)*(j+1-i)) + dp[j+1];
                maxCost = Math.max(cost,maxCost);
            }
            dp[i] = maxCost;
        }
        return dp[0];
    }
    public int f(int i, int n, int k, int[] arr,int[] dp ){
        if(dp[i]!=-1) return dp[i];
        int maxCost = Integer.MIN_VALUE;
        for(int j=i;j<i+k;j++){
            if(j>=n) continue;
            int cost = (findMax(i,j+1,arr)*(j+1-i)) + f(j+1,n,k,arr,dp);
            maxCost = Math.max(cost,maxCost);
        }
        return dp[i] = maxCost;
    }
    public int findMax(int i,int j,int[] arr){
        int max = 0;
        for(int num=i;num<j;num++){
            max = Math.max(max,arr[num]);
        }
        return max;
    }
}