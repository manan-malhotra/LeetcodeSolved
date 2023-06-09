class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int len = nums.length;
        if (len==0) return ans;
        int first = binarySearch(nums,target,true);
        if(first==-1) return ans;
        int second = binarySearch(nums,target,false);
        ans[0]= first;
        ans[1]= second;
        return ans;
    }
    public int binarySearch(int[] arr, int target,boolean first){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]<target){
                start = mid+1;
            }else if(arr[mid]>target){
                end = mid -1;
            }else{
                ans = mid;
                if(first){
                    end = mid -1;
                }else{
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}