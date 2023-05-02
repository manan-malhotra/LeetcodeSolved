class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;i++){
            
           
            int target=2*arr[i];
            if(binarySearch(arr,target,i)!=-1) return true;
        }
        return false;
    }
    private int binarySearch(int[] arr,int target, int i){ 
        int s=0,e = arr.length-1;
        
        while(s<=e){
            int mid = s+ (e-s)/2;
            if(arr[mid]==target && mid!=i)  return mid;
            else if(arr[mid]<target) s=mid+1;
            else e=mid-1;
            
        }
        return -1;
    }
}