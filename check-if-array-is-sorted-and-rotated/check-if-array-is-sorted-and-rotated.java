class Solution {
    public boolean check(int[] nums) {
        int n = nums.length, dropPoint = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) dropPoint++;
        }
        if (dropPoint == 0) return true;
        if (dropPoint == 1 && nums[0] >= nums[n - 1]) return true;
        return false;
    }
}