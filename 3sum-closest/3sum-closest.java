class Solution {
    public int threeSumClosest(int[] nums, int target) {
	int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int aPtr = i+1;
            int bPtr = nums.length-1;
            while(aPtr<bPtr){
                int sum = nums[i]+nums[aPtr]+nums[bPtr];
                if(sum<target){
                    aPtr++;
                }else if(sum>target){
                    bPtr--;
                }else{
                    return sum;
                }
                int diff = Math.abs(sum-target);
                if(diff<minDiff){
                    minDiff=diff;
                    closest=sum;
                }
            }
            
        }
        return closest;
}
}