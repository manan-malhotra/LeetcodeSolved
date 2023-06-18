class Solution {
    public int singleNonDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        if (start==end) return arr[start];
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }else if(arr[mid-1]==arr[mid]){
                if(mid%2==0){
                    end=mid-2;
                }else{
                    start=mid+1;
                }
            }else{
                if(mid%2==0){
                    start=mid+2;
                }else{
                    end = mid -1;
                }
            }
        }
        return arr[end];
    }
}