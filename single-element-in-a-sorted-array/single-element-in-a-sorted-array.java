class Solution {
      public static int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
         while(start<end){
            int mid = start + (end-start)/2;
            if(mid%2!=0) mid--;
            if(mid<end && nums[mid]!=nums[mid+1] && mid>start && nums[mid]!=nums[mid-1]) return nums[mid];
            if(nums[mid]!=nums[mid+1]){
                end = mid - 2;
            }else{
                start = mid + 2;
            }

        }
        return nums[start];
    }
}