class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length/2;
        int[] p = new int[len];
        int[] n = new int[len];
        int pNo=0,nNo=0;
        for(int i : nums){
            if(i>0){
                p[pNo++]=i;
            }else{
                n[nNo++]=i;
            }
        }
        pNo=0;nNo=0;
        for(int i=0;i<nums.length;i++){
            nums[i++]=p[pNo++];
            nums[i]=n[nNo++];
        }
        return nums;
    }
}