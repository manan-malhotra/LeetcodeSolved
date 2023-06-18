class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0 ;
        int end = arr.length;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid!=end && arr[mid+1]>arr[mid]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return end;
    }
}