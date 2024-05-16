class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;
         int start = 0;
        int end = n-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid+1]>arr[mid]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }
}