class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        int[] result = new int[nums.length];

        int start = 0;
        int index = start;
        while (start < nums.length) {
            if (nums[start] < pivot) {
                result[index++] = nums[start];
            }
            start++;
        }
        int pivotLeft = index;

        int end = nums.length - 1;
        index = end;
        while (end >= 0) {
            if (nums[end] > pivot) {
                result[index--] = nums[end];
            }
            end--;
        }
        int pivotRight = index;

        for (int i = pivotLeft; i <= pivotRight; i++) {
            result[i] = pivot;
        }

        nums = result;

        return nums;
    }
}