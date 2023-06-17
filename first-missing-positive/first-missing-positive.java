class Solution {
    public int firstMissingPositive(int[] arr) {
        
        for (int i = 0; i < arr.length;) {
            int correct = arr[i]-1;
            if(arr[i]>0 && arr[i]<arr.length && arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return arr.length +1;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}