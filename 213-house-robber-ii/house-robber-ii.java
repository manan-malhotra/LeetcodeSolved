class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int withoutLast = rob(nums,n-1);
        nums[0] = 0;
        int withoutFirst = rob(nums,n);
        return Math.max(withoutLast,withoutFirst);
    }
    public int rob(int[] nums,int n) {
        if(n==1) return nums[0];
        int prev2 = nums[0];
        int prev = Math.max(prev2,nums[1]);
        for(int i=2;i<n;i++){
            int temp = Math.max(prev,prev2+nums[i]);
            prev2 = prev;
            prev = temp;
        }
        return prev;
    }
}