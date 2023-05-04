class Solution {
    public int missingNumber(int[] arr) {
         int i = 0;
        while(i<arr.length){
            if(i==arr[i] || arr[i] == arr.length){
                i++;
            }else{
                swap(arr,i,arr[i]);
            }
        }
        for( i=0; i<arr.length;i++){
            if(i!=arr[i]) return i;
        }
        return arr.length;
    }
     public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}