class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(nums[0]);
        for(int i=1;i<nums.length;i++){
            dp[i] = nums[i];
            if(i>k && dq.getFirst() == dp[i-k-1]){
                dq.removeFirst();
            }
            dp[i]=Math.max(dp[i],dq.getFirst()+nums[i]);
            while(!dq.isEmpty() && (dq.getLast()<dp[i])){
                dq.removeLast();
            }
            dq.addLast(dp[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}