class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int subsetLength = 1;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            int maxVal = 0;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    maxVal = Math.max(maxVal,dp[j]);
                }
                dp[i] = maxVal+1;
                subsetLength = Math.max(dp[i],subsetLength);
            }
        }
        int prev = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(prev%nums[i]==0 && dp[i]==subsetLength){
                subsetLength--;
                ans.add(nums[i]);
                prev = nums[i];
            }
        }
        return ans;
    }
}



