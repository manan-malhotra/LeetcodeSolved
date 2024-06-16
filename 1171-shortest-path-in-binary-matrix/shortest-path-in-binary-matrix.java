class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = grid[i][j] == 1 ? -1 : Integer.MAX_VALUE;
            }
        }
        grid[0][0] = 1;

        int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        rows.offer(0);
        cols.offer(0);

        int ans = Integer.MAX_VALUE;
        while (!rows.isEmpty()) {
            int row = rows.poll();
            int col = cols.poll();
            if (row == n - 1 && col == n - 1) {
                ans = Math.min(grid[row][col], ans);
            }
            for (int i = 0; i < 8; i++) {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] != -1) {
                    if (grid[nr][nc] > grid[row][col] + 1) {
                        grid[nr][nc] = grid[row][col] + 1;
                        rows.offer(nr);
                        cols.offer(nc);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}