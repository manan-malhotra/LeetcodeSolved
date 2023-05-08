class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = right;

        while (left <= right) {
            if (nums[left] * -1 < nums[right]) {
                result[i--] = nums[right] * nums[right--];
            } else {
                result[i--] = nums[left] * nums[left++];
            }
        }
        return result;
    }
}