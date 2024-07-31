class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(target<0) return findTargetSumWays(nums,-target);
        int total = 0;
        for(int num:nums){
            total+=num;
        }
        int n = nums.length;
        return f(0,0,n,nums,target);
    }
    public int f(int i, int sum,int n, int[] nums, int target ){
        if(i==n){
            return sum==target?1:0;
        }
        return f(i+1,sum+nums[i],n,nums,target) + f(i+1,sum-nums[i],n,nums,target);
    }
}