class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int finalAns = 1;
        for(int i=1;i<n;i++){
            int currMax = -1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(currMax==-1) currMax=j;
                    else currMax = dp[j]>dp[currMax]?j:currMax;
                }
            }
                if (currMax!=-1) dp[i] = dp[currMax] + 1;
                finalAns = Math.max(dp[i],finalAns);
                System.out.println(i+" "+dp[i]+" "+currMax);
        }
        return finalAns;
    }
}

