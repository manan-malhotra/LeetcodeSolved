class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
     
        if(nums[0]<=nums[n-1]){
            return nums[0];
        }
        int mid = findPeak(nums);
        return nums[mid+1];
        
    }

 public int findPeak(int[] nums){
         int start = 0;
        int end = nums.length - 1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid]<nums[mid-1]){
                return mid-1;
            }else if (nums[start]>nums[mid]){
                end = mid-1;

            }else{
                start = mid + 1;
            }
         }
        return -1;
    }

}