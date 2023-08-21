class Solution {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int maxsofar=Integer.MIN_VALUE;
        // -2 1 -3 4 -1 2 1 -5 4
        // 0 1 0 4 3 5 6 1 5
        int[] a = new int[len];
        a[0]=nums[0];
        maxsofar = Math.max(a[0],maxsofar);
        if(a[0]<0) a[0]=0;
        for(int i=1;i<len;i++){
            a[i]=a[i-1]+nums[i];
            maxsofar = Math.max(a[i],maxsofar);
            if(a[i]<0) a[i]=0;
        }
        return maxsofar;
        
    }
}