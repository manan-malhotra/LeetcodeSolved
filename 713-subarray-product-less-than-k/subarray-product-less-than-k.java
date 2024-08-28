class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // Since all numbers are positive, if k <= 1, no subarray will satisfy the condition
        int count = 0;
        int product = 1;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while(right!=n){
            product *= nums[right++];
            while (product >= k) {
                product /= nums[left++];
            }
            count += right - left ; // Adding the number of subarrays ending at 'right'
        }
        
        return count;
    }
}