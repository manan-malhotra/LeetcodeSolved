class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans=new ArrayList<>();
        int index=0;
        for(int i:nums){
            if(i<target){
                index++;
            }
        }
        for(int i:nums){
            if(i==target){
                ans.add(index);
                index++;
            }
        }
        return ans;
    }
}