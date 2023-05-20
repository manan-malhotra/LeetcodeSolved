class Solution {
    public static int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int currMax = 0;
        for(int i:nums){
            currMax+=i;
            if(sum<currMax) sum=currMax;
            if(currMax<0) currMax=0;
        }
        return sum;
    }
}