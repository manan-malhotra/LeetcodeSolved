class Solution {
    public static int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int currMax = 0;
        for(int i:nums){
            currMax+=i;
            sum=Math.max(sum,currMax);
            currMax=Math.max(0,currMax);
        }
        return sum;
    }
}