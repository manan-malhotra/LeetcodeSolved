class Solution {
    public boolean search(int[] nums, int target) {
        int peak = findPeak(nums);
        System.out.println(peak);
        int found = binarySearch(nums,target,0,peak);
        if(found == -1) {
            found = binarySearch(nums,target,peak+1,nums.length-1);
        }
        return found!=-1;
    }
    private int binarySearch(int[] arr, int target,int start,int end) {
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
    private int findPeak(int[] nums) {
          int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end - start)/2;
            if(nums[mid]>nums[mid+1]){
                return mid;
            }else if(mid!=start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                if(nums[start]>nums[start+1]) return start;
                start++;
                if(nums[end-1]>nums[end]) return end-1;
                end--;
            }
            else if (nums[start]>nums[mid]){
                end = mid-1;

            }else{
                start = mid + 1;
            }
        }
        return end;
    }
}