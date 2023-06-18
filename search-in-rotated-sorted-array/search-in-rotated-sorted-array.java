class Solution {
    public int search(int[] nums, int target) {
        int end = nums.length;

        if(nums[0]<=nums[end-1]){
            return binarySearch(nums,target,0,end-1);
        }
       int peak = findPeak(nums);
       int first = binarySearch(nums,target,0,peak);
       if(first!=-1){
           return first;
       }
        return binarySearch(nums,target,peak+1,nums.length-1);
       
       
    }
    public int binarySearch(int[] nums, int target, int start, int end){
        while(start<=end){
            int mid = start + (end - start)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
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