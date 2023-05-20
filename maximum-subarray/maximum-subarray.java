class Solution {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int maxsofar=Integer.MIN_VALUE;
        int maxendinguptohere=0;
        for(int i=0;i<len;i++)
        {
            maxendinguptohere+=nums[i];
            if(maxendinguptohere>maxsofar)
            maxsofar=maxendinguptohere;
            if(maxendinguptohere<0)
            maxendinguptohere=0;
        }
        return maxsofar;
        
    }
}