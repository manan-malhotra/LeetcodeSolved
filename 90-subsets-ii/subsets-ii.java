class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        rec(0,nums,ans,temp);
        return ans;
    }
    public void rec(int i, int[] nums, List<List<Integer>> ans, List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]) continue;
            temp.add(nums[j]);
            rec(j+1,nums,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}