class Solution {
    public int splitArray(int[] nums, int k) {
        int start = findMax(nums);
        int end = findSum(nums);
        while(start<end){
            int mid = start + (end-start)/2; 
            int sum = 0;
            int piece = 1;
            
            for(int i: nums){
                sum += i;
                if(sum>mid){
                    sum = i;
                    piece++;
                }
            }
           if(piece>k){
                start = mid + 1;
            }else{
                end = mid ;
            }
            
        }
        return end;
    }
    public int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if(i>max){
                max = i;
            }
        }
        return max;
    }
    public int findSum(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum+=i;
        }
        return sum;
    }
}