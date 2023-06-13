class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; ){
            int correctIndex = nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                int temp = nums[i];
                nums[i]=nums[correctIndex];
                nums[correctIndex]=temp;
            }else{
                i++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i]-1!=i){
                ans.add(i+1);
            }   
        }
        return ans;
    }
}