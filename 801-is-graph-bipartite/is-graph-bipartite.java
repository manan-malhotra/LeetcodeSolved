class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] color = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(dfs(i,1,vis,color,graph)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int i,int col, int[] vis, int[] color, int[][] graph){
        System.out.println(i+" "+col);
        vis[i] = 1;

        color[i] = col;
        for(int child : graph[i]){
            if(vis[child]==0){
                if(dfs(child,-col,vis,color,graph)) return true;
            }else if(color[child]==col) return true;
        }
        return false;
    }
}