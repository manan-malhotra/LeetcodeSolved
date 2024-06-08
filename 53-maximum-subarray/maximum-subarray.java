class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            sum+=i;
            max=Math.max(sum,max);
            if(sum<0) sum=0;
        }
        return max;
    }
}