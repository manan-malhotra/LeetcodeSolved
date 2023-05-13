class Solution {
    public List<Integer> findDuplicates(int[] nums) {
         int i = 0;
        while (i < nums.length) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            }
            else i++;
        }

        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
    public void swap(int[] nums, int i, int j){
int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    
    }
}