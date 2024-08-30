class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],dp[0]);
        for(int i=2;i<n;i++){
            dp[i%2] = Math.max(dp[(i-1)%2], nums[i]+dp[i%2]);
        }   
        return dp[(n-1)%2];
    }
}