class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        while(n!=0){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0 && !set.contains(nums[i]))  {
                    temp.add(nums[i]);
                    set.add(nums[i]);
                    nums[i] = 0;
                    n--;
                }
            }
            set = new HashSet<>();
            ans.add(new ArrayList<>(temp));
        }
        return ans;

    }
}