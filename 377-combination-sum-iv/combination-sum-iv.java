class Solution {
    int[] t;
    public int combinationSum4(int[] nums, int target) {
        t = new int[target+1];
        Arrays.fill(t,-1);
        return solve(nums,target);
    }
    public int solve(int[] nums, int target)
    {
        if(target == 0) {
            return 1;
        }
        if(target < 0) {
            return 0;
        }
        
        if(t[target] != -1) {
            return t[target];
        }
        
        int result = 0;
        for(int i = 0; i<nums.length;i++) {
            result += solve(nums, target-nums[i]);
        }
        return t[target] = result;
    }
}