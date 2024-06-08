class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0;
        int r = 0;
        int max = 0;
        while(r<nums.length-1){
            for(int i=0;i<=r;i++){
                max=Math.max(max,i+nums[i]);
            }
            l=r+1;
            r=max;
            jumps++;
        }
        return jumps;
    }
}