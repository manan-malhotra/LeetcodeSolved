class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return solve(nums,target,dp);
    }
    public int solve(int[] nums, int target,int[] dp)
    {
        if(target == 0) {
            return 1;
        }
        if(target < 0) {
            return 0;
        }
        
        if(dp[target] != -1) {
            return dp[target];
        }
        
        int result = 0;
        for(int i = 0; i<nums.length;i++) {
            result += solve(nums, target-nums[i],dp);
        }
        return dp[target] = result;
    }
}




