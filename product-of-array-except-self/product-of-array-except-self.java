class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] numsProduct = new int[nums.length]; // Creating an array to store products.
        int preProduct = 1, postProduct = 1; // Initializing a prefix, and postfix product.

        // Find product of each array i, but exclude i.
            // By calculating the left and right products seperately we are able to calculate in O(N) time.
        for(int i = 0; i < nums.length; i++){ // Left Index
            numsProduct[i] = preProduct;
            preProduct *= nums[i];
        }
        
        for(int i = nums.length - 1; i >= 0; i--){ // Right Index
            numsProduct[i] *= postProduct;
            postProduct *= nums[i];
        }

        return numsProduct;
    }
}