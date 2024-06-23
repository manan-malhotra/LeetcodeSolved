class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length==1) return false;
        int target = 0;
        for(int num:nums) target+=num;
        if(target%2==1) return false;
        return partitionSum(nums,nums.length,target/2);
    }
    public boolean partitionSum(int[] nums,int n,int target){
        if(nums[0]>target) return false;
        boolean[][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i]<=j) dp[i][j] = dp[i][j] || dp[i-1][j-nums[i]];
            }
        }
        return dp[n-1][target];
    }
}