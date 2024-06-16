class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n==1){
            if(grid[0][0]==0) return 1;
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        if(grid[0][0]==0 && grid[n-1][n-1]==0)queue.offer(new Node(0,0,1));
        int[] row = {1,1,1,0,0,-1,-1,-1};
        int[] col = {-1,0,1,-1,1,-1,0,1};
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int wt = node.wt;
            if(x==y && x==n-1) return wt;
            for(int i=0;i<8;i++){
                int newRow = x + row[i];
                int newCol = y + col[i];
                if(isValid(newRow,newCol,n,grid)) {
                    queue.offer(new Node(newRow,newCol,wt+1));
                    grid[newRow][newCol]=1;
                }    
            }
        }
        return -1;
    }
    public boolean isValid(int i,int j, int n,int[][] grid){
        return (i>=0 && j>=0 && i<n && j<n && grid[i][j]==0 );
    }
}
class Node{
    int x;
    int y;
    int wt;
    public Node(int x,int y,int wt){
        this.x=x;
        this.y=y;
        this.wt=wt;
    }
}