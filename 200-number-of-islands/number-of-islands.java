class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    island++;
                    helper(i,j,n,m,grid);
                }
            }
        }
        for(int i=0;i>n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='2'){
                    grid[i][j] = '1';
                }
            }
        }
        return island;
    }
    public void helper(int i, int j, int n, int m, char[][] grid){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!='1') return;
        grid[i][j] = '2';
        helper(i-1,j,n,m,grid);
        helper(i+1,j,n,m,grid);
        helper(i,j-1,n,m,grid);
        helper(i,j+1,n,m,grid);
    }
}