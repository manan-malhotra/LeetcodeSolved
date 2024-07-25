class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            for(int j=0; j<n;j++){
                if(i==j) continue;
                if(isConnected[i][j]==1) adj.get(i).add(j);
            }
        }
        int provinces = 0;
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                provinces++;
                dfs(adj,i,vis);
            }
        }
        return provinces;
    }
    public void dfs(List<List<Integer>> adj, int node, int[] vis){
        vis[node] = 1;
        for(int child : adj.get(node)){
            if(vis[child]==0){
                dfs(adj,child,vis);
            }
        }

    }
}