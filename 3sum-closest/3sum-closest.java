class Solution {
    public int threeSumClosest(int[] nums, int target) {
	Arrays.sort(nums);
	int closest = 0;
    int minDiff = Integer.MAX_VALUE;
    for(int i=0;i<nums.length-2;i++){
        int aPtr = i+1;
        int bPtr = nums.length-1;
        while(aPtr<bPtr){
            int sum = nums[i]+nums[aPtr]+nums[bPtr];
            if(sum>target){
                bPtr--;
            }else if(sum<target){
                aPtr++;
            }else{
                return sum;
            }
            int diff = Math.abs(target-sum);
            if(diff<minDiff){
                minDiff = diff;
                closest = sum;
            }

        }
    }
	return closest;
}
}