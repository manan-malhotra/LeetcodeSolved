class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n==0) return -1;
        int ones = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) ones++;
                else if(grid[i][j]==2) {
                    q.offer(new int[]{i , j});
                }
            }
        }
        if(ones==0) return 0;
        int max = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty() && ones!=0){
            ++max;
            int size = q.size();
            for(int i=0;i<size;i++){
            int[] arr = q.poll();
            for(int k=0;k<dir.length;k++){
                int x = arr[0]+ dir[k][0];
                int y = arr[1]+ dir[k][1];
                if(x<0 || y<0 || x>=n || y>=m || grid[x][y]!=1) continue;
                grid[x][y] = 2;
                ones--;
                q.offer(new int[]{x , y});
            }
            }
        }    
        if(ones==0) return max;
        return -1;    
    }
    
}