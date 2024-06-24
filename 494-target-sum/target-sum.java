class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return findTarget(n-1,target,nums);
    }
    public int findTarget(int i, int target, int[] nums){
        if(i==0){
            if(nums[0]== target && nums[0]==target*-1) return 2;
            if(nums[0]== target || nums[0]==target*-1) return 1;
            return 0;
        }
        int add = findTarget(i-1,target+nums[i],nums);
        int sub = findTarget(i-1,target-nums[i],nums);
        return add + sub ;
    }
}