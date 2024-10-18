class Solution {
    class Level{
        int value;
        int i;
        int j;
        public Level(int value, int i, int j){
            this.value = value;
            this.i=i;
            this.j=j;
        }
    }
    public int swimInWater(int[][] grid) {
        int maxLevel = grid[0][0];
        int n = grid.length;
        PriorityQueue<Level> pq = new PriorityQueue<Level>((x,y)->x.value-y.value);
        Level init = new Level(grid[0][0],0,0);
        int[] row = {-1,1,0,0};
        int[] col = {0,0,1,-1};
        pq.add(init);
        int vis[][] = new int[n][n];
        while(pq.size()>0){
            Level level = pq.remove();
            maxLevel = Math.max(maxLevel,level.value);
            int oldI = level.i;
            int oldJ = level.j;
            if(oldI==n-1 && oldJ==n-1){
                return maxLevel;
            }
            for(int i=0;i<4;i++){
                int newI = oldI + row[i];
                int newJ = oldJ + col[i];
                if(newI>=0 && newJ>=0 && newI<n && newJ<n && vis[newI][newJ]==0){
                    vis[newI][newJ] = 1;
                    pq.add(new Level(grid[newI][newJ],newI,newJ));
                }
            }
            
        }
        return maxLevel;
    }
}