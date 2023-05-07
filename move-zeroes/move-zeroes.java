
    class Solution {
    public void moveZeroes(int[] nums) {
        
        int currNonZero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[currNonZero++]= nums[i];
                
            }
        }
        for(int j=currNonZero;j<nums.length;j++){
            nums[j]=0;
        }
        
    }
}
