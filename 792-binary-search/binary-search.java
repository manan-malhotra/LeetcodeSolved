class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int foundAt=-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) {
                foundAt = mid;
                end=start-1;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return foundAt;
    }
}