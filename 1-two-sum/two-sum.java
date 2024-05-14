class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[] {hm.get(target-nums[i]),i};
            }
            hm.put(nums[i],i);
        }
        return null;
    }
}