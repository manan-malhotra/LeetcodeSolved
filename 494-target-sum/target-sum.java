class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num:nums) total += num;
        if(total-target<0) return 0;
        if((total-target)%2==1) return 0;
        int newTarget = (total-target)/2;
        int n = nums.length;
        int[][] dp = new int[n][newTarget+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return findTarget(n-1,newTarget,nums,dp);
    }
    public int findTarget(int i, int target, int[] arr, int[][] dp){
        if(dp[i][target]!=-1) return dp[i][target];
        if(i==0){
            if(target==0 && arr[i]==0) return dp[0][0]=2;
            if(target==0 || arr[i]==target) return dp[0][target]=1;
            return 0;
        }
        int notTake = findTarget(i-1,target,arr,dp);
        int take = 0;
        if(arr[i]<=target) take = findTarget(i-1,target-arr[i],arr,dp);
        return dp[i][target] = take + notTake;
    }
}