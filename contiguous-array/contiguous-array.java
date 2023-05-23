class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            int add = 1;
            if(nums[i]==0){
                add = -1;
            }
            sum+=add;
            if(sum==0){
                maxLen = Math.max(maxLen,i+1);
            }
            if(hm.containsKey(sum)){
                int len = i - hm.get(sum);
                maxLen = Math.max(maxLen, len);
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return maxLen;
    }
}