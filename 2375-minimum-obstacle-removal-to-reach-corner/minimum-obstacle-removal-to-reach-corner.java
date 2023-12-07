class Solution {

    final private static int[] X_DIRECTION = new int[]{1, -1, 0, 0};
    final private static int[] Y_DIRECTION = new int[]{0, 0, 1, -1};

    public int minimumObstacles(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int minSoFar = n + m - 3;

        int ones = 0;
        int totalSquares = n * m;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ones += grid[i][j];
            }
        }
        if (ones == 0) {
            return 0;
        }
        if (totalSquares - ones == 2) {
            return minSoFar;
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] visitedDist = new int[n][m];
        for (int i = 0; i < visitedDist.length; i++) {
            Arrays.fill(visitedDist[i], Integer.MAX_VALUE);
        }


        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int row = p[0];
            int col = p[1];
            int obs = p[2];

            if (row == grid.length - 1 && col == grid[0].length - 1) {
                minSoFar = Math.min(minSoFar, obs);
                return minSoFar;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = row + X_DIRECTION[dir];
                int nextCol = col + Y_DIRECTION[dir];

                if (nextRow < n && nextRow >= 0 && nextCol < m && nextCol >= 0) {
                    if (visitedDist[nextRow][nextCol] > obs + grid[nextRow][nextCol]) {
                        if (grid[nextRow][nextCol] == 1) {
                            queue.addLast(new int[]{nextRow, nextCol, obs + grid[nextRow][nextCol]});
                        } else {
                            queue.addFirst(new int[]{nextRow, nextCol, obs + grid[nextRow][nextCol]});
                        }
                        visitedDist[nextRow][nextCol] = obs + grid[nextRow][nextCol];
                    }
                }

            }
        }

        return minSoFar;
    }
}