class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                bfs(grid,i,0,n,m);
            }
            if(grid[i][m-1]==1){
                bfs(grid,i,m-1,n,m);
            }
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==1){
                bfs(grid,0,j,n,m);
            }
            if(grid[n-1][j]==1){
                bfs(grid,n-1,j,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
    public void bfs(int[][] grid, int i,int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!=1) return;
        grid[i][j]=0;
        bfs(grid,i+1,j,n,m);
        bfs(grid,i-1,j,n,m);
        bfs(grid,i,j+1,n,m);
        bfs(grid,i,j-1,n,m);

    }
}