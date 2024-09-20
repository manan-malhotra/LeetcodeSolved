class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxR = new int[n];
        int[] maxC = new int[n];
        for(int i=0;i<n;i++){
            int max = 0;    
            for(int j=0;j<n;j++) max=Math.max(max,grid[i][j]);
            maxR[i] = max;
        }
        for(int j=0;j<n;j++){
            int max = 0;    
            for(int i=0;i<n;i++) max=Math.max(max,grid[i][j]);
            maxC[j] = max;
        }
        for(int m:maxR) System.out.println(m);
        for(int m:maxC) System.out.println(m);
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int maxVal = Math.min(maxC[i],maxR[j]);
                ans += (maxVal-grid[i][j]);
                grid[i][j] = maxVal;
            }
        }
        return ans;
    }
}