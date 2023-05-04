class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        List<Integer> arr = new ArrayList<>();
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i]==nums[correct]){
                i++;
            }else{
                swap(nums,i,correct);
            }
        }
        for(int j=0;j<nums.length;j++){
            if(j!=nums[j]-1){
                arr.add(nums[j]);
            }
        }
        return arr;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}