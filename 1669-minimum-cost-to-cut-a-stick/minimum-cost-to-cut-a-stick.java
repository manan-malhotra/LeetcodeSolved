class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        List<Integer> arr = new ArrayList<>();
        for (int i : cuts)
            arr.add(i);
        arr.add(0);
        arr.add(n);
        Collections.sort(arr);
        int[][] dp = new int[c + 2][c + 2];
        for (int i = c; i >= 1; i--) {
            for (int j = i; j <= c; j++) {
                // if (i > j)
                //     continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int ans = arr.get(j + 1) - arr.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, ans);
                }

                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }
}

