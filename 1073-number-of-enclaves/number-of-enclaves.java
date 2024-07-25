class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==1)dfs(i,0,grid);
            if(grid[i][m-1]==1)dfs(i,m-1,grid);
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==1)dfs(0,i,grid);
            if(grid[n-1][i]==1)dfs(n-1,i,grid);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) grid[i][j] = 1;
                else if(grid[i][j]==1) ans++;;
            }
        }
        return ans;
    }
    public void dfs(int i, int j, int[][] board){
        if(i<0 || j<0 || i>= board.length || j>= board[0].length || board[i][j]!=1) return;
        board[i][j]=2;
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }
}