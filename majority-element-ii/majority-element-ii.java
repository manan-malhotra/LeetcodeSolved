class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        List<Integer> ans = new ArrayList<>();
         Set<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            if(hm.get(nums[i])*3>n) hs.add(nums[i]);
        }
        for(int i=0;i<n;i++){
            if(hs.contains(nums[i])){
                ans.add(nums[i]);
                hs.remove(nums[i]);
            }
        }
        return ans;

    }
}