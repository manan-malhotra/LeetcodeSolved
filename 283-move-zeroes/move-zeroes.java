class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int z = 0;
        int num = 0;
        while(num!=n && z!=n){
            if(nums[num]==0) num++;
            else{
                nums[z++] = nums[num++];
            }
        }
        while(z!=n){
            nums[z++] = 0;
        }
    }
}