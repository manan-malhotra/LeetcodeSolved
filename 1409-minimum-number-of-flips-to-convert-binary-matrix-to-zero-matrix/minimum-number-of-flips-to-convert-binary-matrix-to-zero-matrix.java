class Solution {
    private int ans;
    private int[][] dir = {{-1,0}, {0,-1}, {0,0}, {0,1}, {1,0}};
    public int minFlips(int[][] a) {
        ans = 123456789;
        dfs(a, 0, 0, 0);
        return ans == 123456789 ? -1 : ans;
    }

    private void dfs(int[][] a, int x, int y, int step) {
        if (x == a.length -1 && y == a[0].length) {
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a[0].length; j++)
                    if (a[i][j] != 0)
                        return;
            ans = Math.min(ans, step);
        }
        if (step >= ans)
            return;
        if (y == a[0].length) {
            x++;
            y = 0;
        }
        dfs(a, x, y + 1, step);
        for (int[] d : dir) {
            if (x + d[0] >= 0 && x + d[0] < a.length && y +d[1] >= 0 && y + d[1] < a[0].length)
                a[x + d[0]][y +d[1]] = 1 - a[x + d[0]][y +d[1]];
        }
        dfs(a, x, y + 1, step + 1);
        for (int[] d : dir) {
            if (x + d[0] >= 0 && x + d[0] < a.length && y +d[1] >= 0 && y + d[1] < a[0].length)
                a[x + d[0]][y +d[1]] = 1 - a[x + d[0]][y +d[1]];
        }
    }
}