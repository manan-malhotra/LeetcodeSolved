class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n==0) return -1;
        int ones = 0;
        Queue<List<Integer>> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) ones++;
                else if(grid[i][j]==2) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    arr.add(0);
                    q.offer(arr);
                }
            }
        }
        int max = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            List<Integer> arr = q.poll();
            for(int k=0;k<dir.length;k++){
                int x = arr.get(0)+ dir[k][0];
                int y = arr.get(1)+ dir[k][1];
                if(x<0 || y<0 || x>=n || y>=m || grid[x][y]!=1) continue;
                grid[x][y] = 2;
                int time = arr.get(2)+1;
                max = Math.max(max,time);
                ones--;
                List<Integer> arr2 = new ArrayList<>();
                arr2.add(x);
                arr2.add(y);
                arr2.add(time);
                q.offer(arr2);
            }
        }    
        if(ones==0) return max;
        return -1;    
    }
    
}