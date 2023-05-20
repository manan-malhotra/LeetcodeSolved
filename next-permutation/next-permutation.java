class Solution {
    public void nextPermutation(int[] nums) {
        // pivot is the element just before the non-increasing (weakly decreasing) suffix
        int pivot = findPivot(nums)-1;
        // paritions nums into [prefix pivot suffix]
        if(pivot!=-1){
            int nextGreaterElement = findNext(nums,pivot);
            // next prefix must exist because pivot < suffix[0], otherwise pivot would be part of suffix
            swap(nums,pivot,nextGreaterElement);
            // this minimizes the change in prefix
        }
        reverseSuffix(nums,pivot+1);
        // reverses the whole list if there was no pivot
    }
    /* Reverse numbers starting from an index till the end. */
    private static void reverseSuffix(int[] nums, int start) {
        int end = nums.length-1;
        while(start<end){
            swap(nums, start++, end--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }

    private static int findNext(int[] nums, int pivot) {
        int threshold = nums[pivot];
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>threshold) return i;
        }
        return 0;
    }
    /* Find the last element which is a peak.
    * In case there are multiple equal peaks, return the first of those.
    * @return first index of last peak
    */
    private static int findPivot(int[] nums) {
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                return i;
            }
        }
        return 0;
    }
}