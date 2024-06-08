class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = nums[0];

        for(int i=0; i<nums.length; i++) {
             currSum+= nums[i];

            maxSum = currSum > maxSum ? currSum : maxSum;
            if(currSum < 0) currSum = 0;
        }
        return maxSum;
    }
}