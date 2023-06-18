class Solution {
    public boolean search(int[] nums, int target) {
        int peak = findPeak(nums);
        System.out.println(peak);
        int found = binarySearch(nums,target,0,peak);
        if(found == -1) {
            found = binarySearch(nums,target,peak+1,nums.length-1);
        }
        return found!=-1;
    }
    private int binarySearch(int[] arr, int target,int start,int end) {
        while(start<=end){
            int mid = start + (end-start)/2;
            int ans = arr[mid];
            if(ans==target){
                return mid;
            }else if(ans>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    private int findPeak(int[] arr) {
          int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[start]==arr[mid] && arr[mid] == arr[end]){
                if(start<end && arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                if(end>start && arr[end]<arr[end-1]){
                    return end-1;
                }
                end--;
            }else if(arr[start]<arr[mid]){
                start=mid+1;
            }else if(arr[start]==arr[mid] && arr[mid]>arr[end]){
                start = mid+1;
            }else{
                end = mid-1;
            }

        }
        return end;
    }
}