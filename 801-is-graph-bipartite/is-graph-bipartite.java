class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0 && !dfs(i,graph,color,1,vis)) return false;
        }
        return true;
    }
    public boolean dfs(int i, int[][] graph, int[] color, int col, int[] vis){
        
        if(vis[i]==1){
            if(color[i]!=col) return false;
            return true;
        }
        
        vis[i]=1;
        System.out.println(i+" "+Arrays.toString(color));
        if(color[i]==0){
            color[i] = col;
            for(int j:graph[i]){
                if(!dfs(j,graph,color,col*-1,vis)) return false;
            }
        }
        return true;
    }
}