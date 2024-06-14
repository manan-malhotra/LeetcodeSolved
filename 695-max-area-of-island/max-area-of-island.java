class Solution {
    int area = 0;
    int currentCount = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    currentCount=0;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return area;
    }
    public void dfs(int[][] grid,int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0) return;
        grid[i][j]=0;
        currentCount++;
        area=Math.max(area,currentCount);
        dfs(grid,i+1,j,n,m);
        dfs(grid,i,j+1,n,m);
        dfs(grid,i,j-1,n,m);
        dfs(grid,i-1,j,n,m);
    }
}