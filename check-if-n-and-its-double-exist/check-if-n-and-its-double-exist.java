class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;i++){
            
            if(arr[i]==0){
                if(i!=arr.length-1 && arr[i+1]==0){
                return true;
                }else{
                    continue;
                }
            }
            int target=2*arr[i];
            if(binarySearch(arr,target)!=-1) return true;
        }
        return false;
    }
    private int binarySearch(int[] arr,int target){ 
        int s=0,e = arr.length-1;
        
        while(s<=e){
            int mid = s+ (e-s)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<target) s=mid+1;
            else e=mid-1;
            
        }
        return -1;
    }
}