class Solution {
    public void moveZeroes(int[] nums) {
        int lastIndexUsed = 0;
        int currNonZero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[currNonZero++]= nums[i];
                lastIndexUsed = currNonZero;
            }
        }
        for(int j=lastIndexUsed;j<nums.length;j++){
            nums[j]=0;
        }
        
    }
}