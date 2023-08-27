class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n-k;
        // k:2 n:6 6-2=4 4th elem after sort is 5
        Arrays.sort(nums);
        return nums[k];
    }
}