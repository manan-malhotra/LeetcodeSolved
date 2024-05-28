class Solution {
    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt=0;
        // if(preSum==k) cnt++;
        
        for(int i=0;i<nums.length;i++){
            map.put(preSum,map.getOrDefault(preSum,0)+1);
            preSum+=nums[i];
            cnt+=map.getOrDefault(preSum-k,0);
            
        }
        return cnt;
    }
}