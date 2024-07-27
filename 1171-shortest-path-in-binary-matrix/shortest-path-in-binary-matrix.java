class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1]==1) return -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) grid[i][j] = Integer.MAX_VALUE;
            }
        }
        grid[0][0] = 1;
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        q.offer(start);
        int[] dRow = {-1,-1,-1,0,0,1,1,1};
        int[] dCol = {-1,0,1,1,-1,-1,0,1};
        while(!q.isEmpty()){
            List<Integer> node = q.remove();
            int i = node.get(0);
            int j = node.get(1);
            if(i==n-1 && j==n-1) return grid[n-1][n-1];
            // System.out.println(i+" "+j+" start");
            int weight = grid[i][j];
            for(int ii=0;ii<8;ii++){
                int newI = i+dRow[ii];
                int newJ = j+dCol[ii];
                // System.out.println(newI+" "+newJ);
                if(newI<0 || newJ<0 || newI>=n || newJ>=n || grid[newI][newJ]!=0) continue;
                List<Integer> newNode = new ArrayList<>();
                newNode.add(newI);
                newNode.add(newJ);
                q.offer(newNode);
                grid[newI][newJ] = weight+1;
            }
        }
        int ans = grid[n-1][n-1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==Integer.MAX_VALUE) grid[i][j] = 1;
                else grid[i][j] = 0;
            }
        }
        if(ans==0) return -1;
        return ans;
    }
}