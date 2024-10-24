class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int swapRecord = 1, fixRecord = 0;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i - 1] >= nums2[i] || nums2[i - 1] >= nums1[i]) {
                swapRecord++;
            } else if (nums1[i - 1] >= nums1[i] || nums2[i - 1] >= nums2[i]) {
                int temp = swapRecord;
                swapRecord = fixRecord + 1;
                fixRecord = temp;
            } else {
                int min = Math.min(swapRecord, fixRecord);
                swapRecord = min + 1;
                fixRecord = min;
            }
        }
        return Math.min(swapRecord, fixRecord);
    }
}