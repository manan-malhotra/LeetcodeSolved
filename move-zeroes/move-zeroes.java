
    class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0, j=0;i<nums.length;){
            if(nums[i]==0){
                i++;
            }else{
                
                    swap(nums,i++,j++);
                
            }
        }
        
        
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
