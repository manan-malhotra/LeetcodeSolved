class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        int[] result = new int[nums.length];
        int start = 0;
        int index = start;
        int pivotCount = 0;
        while (start < nums.length) {
            if (nums[start] < pivot) {
                result[index++] = nums[start];
            }else if(nums[start]==pivot)pivotCount++;
            start++;
        }
        while(pivotCount>0){
            pivotCount--;
            result[index++]=pivot;
        }

        int end = nums.length - 1;
        index = end;
        while (end >= 0) {
            if (nums[end] > pivot) {
                result[index--] = nums[end];
            }
            end--;
        }

        nums = result;

        return nums;
    }
}