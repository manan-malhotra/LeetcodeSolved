class Solution {
    Integer dp[][][];
    public int cherryPickup(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return f(grid, 0, 0, grid[0].length-1);
    }
    private int f(int grid[][], int r, int c1, int c2) {
        if(r == grid.length) return 0;
        if(!check(grid[0].length, c1, c2)) return -1;
        if(dp[r][c1][c2] != null) return dp[r][c1][c2];
        int max = 0;
        for(int i = -1; i<=1; i++) {
            for(int j = -1; j<=1; j++) {
                int curr = f(grid, r+1, c1+i, c2+j);
                if(curr == -1) continue;
                max = Math.max(max, curr);
            }
        }
        return dp[r][c1][c2] = grid[r][c1] + grid[r][c2] + max;
    }
    private boolean check(int m, int c1, int c2) {
        if(c1 < 0 || c2 < 0 || c1 >= m || c2 >= m) return false;
        if(c1 == c2) return false;
        return true;
    }
}