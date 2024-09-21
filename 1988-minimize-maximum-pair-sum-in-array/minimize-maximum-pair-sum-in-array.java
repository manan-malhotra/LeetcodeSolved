class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length ;
        int max = 0;
        int i = 0;
        int j = n-1;
        Arrays.sort(nums);
        while(i<=j){
            max = Math.max(max, nums[i++]+nums[j--]);
        }
        return max;
    }
}