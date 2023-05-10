class Solution {
    public void rotate(int[] arr, int d) {
         int n = arr.length;
         if (n < 2) return;
        
        // Get the effective number of rotations:
        d = d%n;
        d=n-d;

        //step 1:
        reverse(arr, 0, d-1);

        //step 2:
        reverse(arr, d, n - 1);

        //step 3:
        reverse(arr, 0, n - 1);
        
    }
    public void reverse(int[] nums, int first, int last){
        while(first<last){
            swap(nums,first,last);
            first++;
            last--;
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}