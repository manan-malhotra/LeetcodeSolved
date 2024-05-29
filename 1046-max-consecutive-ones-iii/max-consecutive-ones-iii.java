class Solution {
    public int longestOnes(int[] nums, int k) {

        int i = 0, j = 0;
        int ans = 0;
        while (j != nums.length) {
            if (nums[j] == 0) {
                k--;
                if (k == -1) {

                    while (k != 0 && i <= j) {
                        if (nums[i] == 0)
                            k++;
                        i++;
                    }
                }
            }

            ans = Math.max(ans, j - i + 1);
            j++;
            System.out.println(k + " " + ans);
        }
        return ans;
    }
}