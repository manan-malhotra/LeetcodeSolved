class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int vis[] = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                boolean isPartite = dfs(i,1,vis,graph);
                if(isPartite) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int val, int[] vis, int[][] graph){
        vis[node] = val;
        int[] child = graph[node];
        for(int ch : child){
            if(vis[ch]==0) if(dfs(ch,-1*val,vis,graph))return true;
            if(vis[ch]==val) return true;
        }
        return false;
    }
}