class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int pivot = findPivot(nums,n);
        // return pivot;
        return nums[(pivot+1)%n];
    }
    public int findPivot(int[] arr,int n){
        int start = 0;
        int end = n-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid!=n-1 && arr[mid]>arr[mid+1]) return mid;
            if(mid!=0 && arr[mid]<arr[mid-1]) return mid-1;
            if(arr[mid]<arr[start]){
                end=mid-1;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
}