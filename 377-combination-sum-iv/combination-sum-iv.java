class Solution {
    public int combinationSum4(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] row: dp) Arrays.fill(row,-1);
        for(int i=0;i<n;i++){
            if(nums[i]<=target){
                ans+= addCombinationStartingWith(i,target-nums[i],nums,n,dp);
            }
        }
        return ans;
    }
    public int addCombinationStartingWith(int start, int target, int[] nums, int n,int[][] dp){
        if(dp[start][target]!=-1) return dp[start][target] ; 
        int ans = 0;
        if(target==0) return dp[start][target] = 1;
        for(int i=0;i<n;i++){
            if(nums[i]<=target){
                ans+= addCombinationStartingWith(i,target-nums[i],nums,n,dp);
            }
        }
        return dp[start][target] = ans;
    }
}