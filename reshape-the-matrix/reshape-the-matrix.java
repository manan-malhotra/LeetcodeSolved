class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (r * c != m * n) return nums;
        int[][] res = new int[r][c];
        for (int i = 0, k = 0, l = 0; i < m; i++) {
            for (int j = 0; j < n; j++, l++) {
                if (l == c) {
                    k++;
                    l = 0;
                }
                res[k][l] = nums[i][j];
            }
        }
        return res;
    }
}