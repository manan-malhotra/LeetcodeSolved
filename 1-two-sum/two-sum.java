class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int remaining = target - nums[i];
            if(map.containsKey(remaining)){
                ans[0] = map.get(remaining);
                ans[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}