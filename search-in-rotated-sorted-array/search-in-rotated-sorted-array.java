class Solution {
    public int search(int[] nums, int target) {
        if(nums[0]<=nums[nums.length-1]){
            return binarySearch(nums,target,0,nums.length-1);
        }
        int peak = findPeak(nums);
        if(target>=nums[0]){
            return binarySearch(nums,target,0,peak);
        }else{
            return binarySearch(nums,target,peak+1,nums.length-1);
        }
    }
    private int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length-1;
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
    private static int binarySearch(int[] arr, int target,int start,int end) {
        while(start<=end){
            int mid = start + (end-start)/2;
            int ans = arr[mid];
            if(ans==target){
                return mid;
            }else if(ans>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}