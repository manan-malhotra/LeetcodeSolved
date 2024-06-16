class Solution {
    public static class wtComparator implements Comparator<int[]>{
        public int compare(int a[], int b[]){
            return a[0]-b[0];
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new wtComparator());
        int n = heights.length;
        int m = heights[0].length;
        int[][] visited = new int[n][m];
        pq.offer(new int[]{0,0,0});
        for(var a : visited) Arrays.fill(a,Integer.MAX_VALUE);
        visited[0][0]=0;
        int[] row = {1,-1,0,0};
        int[] col = {0,0,1,-1};

        int ans = Integer.MAX_VALUE;
        while(pq.size()!=0){
            int[] node = pq.poll();
            int x = node[0];
            int y = node[1];
            int wt = node[2];
            for(int i=0;i<4;i++){
                int newX = x + row[i];
                int newY = y + col[i];
                if(isValid(newX,newY,n,m)){
                    int newWt = Math.abs(heights[newX][newY]-heights[x][y]);
                    newWt = Math.max(wt,newWt);
                    if(visited[newX][newY]>newWt){
                    visited[newX][newY]=newWt;
                    pq.offer(new int[]{newX,newY,newWt});
                    }
                }
            }
        }
        return visited[n-1][m-1];
    }
    public boolean isValid(int i,int j,int n,int m){
        
        return (i>=0 && j>=0 && i<n && j<m);
    }
}