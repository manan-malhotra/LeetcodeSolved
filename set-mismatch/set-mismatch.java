class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] arr = new int[nums.length+1];
        for(int num : nums){
            arr[num] = arr[num]+1;
        }
        for(int i = 1; i<arr.length;i++){
            if(arr[i] == 2){
                result[0] = i;
            }
            if(arr[i] == 0){
                result[1] = i;
            }
        }
        return result;
    }
}