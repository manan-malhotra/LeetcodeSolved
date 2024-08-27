class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0) return false;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]) && map.get(nums[i])>=i-k) return true;
            map.put(nums[i],i);
        }
        return false;
    }
}