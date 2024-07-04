class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int powerSet = 1<<n;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<powerSet;i++){
            List<Integer> temp = new ArrayList<>();
            int curr = i;
            int j=0;
            while(curr!=0){
                if((curr&1)==1) temp.add(nums[j]);
                curr = curr>>1;
                j++;
            }
            ans.add(new ArrayList<Integer>(temp));
        }
        return ans;
    }
}