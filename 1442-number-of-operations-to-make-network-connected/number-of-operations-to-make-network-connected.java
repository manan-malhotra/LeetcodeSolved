class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(m<n-1) return -1;
        List<List<Integer>> adj = createGraph(connections,n);
        int connectedIsland = connectedGraphs(adj);
        return connectedIsland-1;
    }
    public List<List<Integer>> createGraph(int[][] connections,int n){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] connection : connections){
            int to = connection[0];
            int from = connection[1];
            adj.get(to).add(from);
            adj.get(from).add(to);
        }
        return adj;
    }
    public int connectedGraphs(List<List<Integer>> adj){
        int count = 0;
        int n = adj.size();
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0) {
                dfs(i,vis,adj);
                count++;
            }    
        }
        return count;
    }
    public void dfs(int parent, int[] vis, List<List<Integer>> adj){
            vis[parent] = 1;
            for(int child : adj.get(parent)){
                if(vis[child]==0) dfs(child,vis,adj);
            }
    }
}