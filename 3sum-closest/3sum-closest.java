class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int a = i+1;
            int b = nums.length-1;
            while(a<b){
                int sum = nums[i]+nums[a]+nums[b];
                if(sum>target) b--;
                else if(sum<target) a++;
                else return sum;

                int diff = Math.abs(target-sum);
                if(diff<minDiff){
                    minDiff=diff;
                    closest=sum;
                }
            }

        }
        return closest;
    }
}