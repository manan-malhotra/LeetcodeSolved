class Solution { 

    private int productIfNumIsZero(int[] nums, int k) {
        int res = 1;
        boolean flag = false;
        for(int i=0;i<nums.length;i++) {
            if(i!=k) {
                flag = true;
                res *= nums[i];
            }
        }
        return flag ? res : 0;
    } 
    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res = 1;
        for(int i=0;i<n;i++) {
            res *= nums[i];
        }

        int ans[] = new int[n];

        for(int i=0;i<n;i++) {
            int num = nums[i];
            if(num != 0) {
                ans[i] = res / num;
            } else {
                ans[i] = productIfNumIsZero(nums, i);
            }
        }

        return ans;

    }
}