class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length, l = k - 1, r = k + 1;
        int min = nums[k], maxScore = nums[k];

        while (l >= 0 || r < n) {
            if (l < 0 || (r < n && nums[l] < nums[r])) {
                min = Integer.min(min, nums[r]);
                r++;
            } else {
                min = Integer.min(min, nums[l]);
                l--;
            }
            maxScore = Integer.max(maxScore, (r - l - 1) * min);
        }

        return maxScore;
    }
}