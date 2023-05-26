class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int aPtr = m-1;
        int bPtr = n-1;
        int mainPtr = nums1.length-1;
        while(bPtr>=0 && aPtr>=0){
            if(nums1[aPtr]>nums2[bPtr]){
                nums1[mainPtr--]=nums1[aPtr--];
            }else{
                nums1[mainPtr--]=nums2[bPtr--];
            }
        }
        while(bPtr>=0){
            nums1[mainPtr--]=nums2[bPtr--];
        }
    }
}