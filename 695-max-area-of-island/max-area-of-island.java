class Solution {
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,0,n,m);
                }
            }
        }
        return area;
    }
    public int dfs(int[][] grid,int i,int j, int currentCount,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0) return currentCount;
        grid[i][j]=0;
        currentCount++;
        area=Math.max(area,currentCount);
        currentCount=dfs(grid,i+1,j,currentCount,n,m);
        currentCount=dfs(grid,i,j+1,currentCount,n,m);
        currentCount=dfs(grid,i,j-1,currentCount,n,m);
        currentCount=dfs(grid,i-1,j,currentCount,n,m);
        return currentCount;
    }
}