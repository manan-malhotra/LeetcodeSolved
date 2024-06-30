class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[k];
        for(int i=n-1;i>=0;i--){
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(j>=n) continue;
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = (len * maxi )+ dp[(j + 1)%k];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i%k] = maxAns;
        }
        return dp[0];
    }
}


