class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int ones = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1) ones++;
                else queue.offer(new Pair(i,j));
            }
        }
        if(ones==0) return mat;
        int[][] ans = new int[n][m];
        int distance = 0;
        int[] row = {0,0,1,-1};
        int[] col = {1,-1,0,0};
        while(!queue.isEmpty() && ones!=0){
            distance++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> pair = queue.poll();
                int x = pair.getKey();
                int y = pair.getValue();
                for(int j=0;j<4;j++){
                    int newRow = x+row[j];
                    int newCol = y+col[j];
                    if(newRow<0 || newRow>=n || newCol<0 || newCol>=m || mat[newRow][newCol]==0) continue;
                    mat[newRow][newCol]=0;
                    queue.offer(new Pair(newRow,newCol));
                    ans[newRow][newCol] = distance;
                    ones--;
                }
            }
        }
        return ans;
    }   
}