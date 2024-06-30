class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[n] = 0;
        return f(0,n,k,arr,dp);
    }
    public int f(int i, int n, int k, int[] arr,int[] dp ){
        if(dp[i]!=-1) return dp[i];
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int j=i;j<i+k;j++){
            if(j>=n) continue;
            len++;
            maxi = Math.max(maxi,arr[j]);
            int cost = (len*maxi) + f(j+1,n,k,arr,dp);
            maxAns = Math.max(cost,maxAns);
        }
        return dp[i] = maxAns;
    }
}