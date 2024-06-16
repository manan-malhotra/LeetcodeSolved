class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y)->x.wt-y.wt);
        int n = heights.length;
        int m = heights[0].length;
        int[][] visited = new int[n][m];
        pq.offer(new Node(0,0,0));
         for(var a : visited) Arrays.fill(a,Integer.MAX_VALUE);
        visited[0][0]=0;
        int[] row = {1,-1,0,0};
        int[] col = {0,0,1,-1};
        int ans = Integer.MAX_VALUE;
        while(pq.size()!=0){
            Node node = pq.poll();
            int x = node.x;
            int y = node.y;
            int wt = node.wt;
            for(int i=0;i<4;i++){
                int newX = x + row[i];
                int newY = y + col[i];
                if(isValid(newX,newY,n,m,visited)){
                    int newWt = Math.abs(heights[newX][newY]-heights[x][y]);
                    newWt = Math.max(wt,newWt);
                    if(visited[newX][newY]>newWt){
                    visited[newX][newY]=newWt;
                    pq.offer(new Node(newX,newY,newWt));
                    }
                }
            }
        }
        return visited[n-1][m-1];
    }
    public boolean isValid(int i,int j,int n,int m, int[][] visited){
        
        return (i>=0 && j>=0 && i<n && j<m);
    }
}
class Node{
    int x;
    int y;
    int wt;
    public Node(int x, int y, int wt){
        this.x=x;
        this.y=y;
        this.wt=wt;
    }
}