class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> triplet = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
             if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
            int aPtr = i+1;
            int bPtr = nums.length-1;
            int sum = 0-nums[i];
            while(aPtr<bPtr){
                if(nums[aPtr]+nums[bPtr]==sum){
                    ans.add(Arrays.asList(nums[i], nums[aPtr], nums[bPtr]));
                    while (aPtr < bPtr && nums[aPtr] == nums[aPtr + 1]) aPtr++;
                    while (aPtr < bPtr && nums[bPtr] == nums[bPtr - 1]) bPtr--;

                    aPtr++;
                    bPtr--;
                }else if(nums[aPtr]+nums[bPtr]>sum){
                    bPtr--;
                }else{
                    aPtr++;
                }
            }
            }
        }
        return ans;
        }
    
}