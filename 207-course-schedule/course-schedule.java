class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : prerequisites){
            int u = edge[1];
            int v = edge[0];
            adj.get(u).add(v);
        }
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathVis))
                    return false;
            } 
        }
        return true;
    }
    public boolean dfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int child : adj.get(node)){
            if(vis[child]==0){
                if(dfs(child,adj,vis,pathVis)) return true;
            }else if(pathVis[child]==1) return true;
        }
        pathVis[node] = 0;
        return false;
    }
}