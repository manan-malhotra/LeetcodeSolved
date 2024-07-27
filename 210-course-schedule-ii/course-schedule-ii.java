class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : prerequisites){
            int u = edge[1];
            int v = edge[0];
            adj.get(u).add(v);
        }
        int[] ans = new int[0];
        if(!canFinish(n,adj)) return ans;
        return topoSort(adj);
    }
    public int[] topoSort(List<List<Integer>> adj){
        int n = adj.size();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            List<Integer> node = adj.get(i);
            for(int child : node){
                indegree[child]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] topo = new int[n];
        for(int i=0;i<n;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        int i = 0;
        while(!queue.isEmpty()){
            topo[i++] = queue.peek();
            int node = queue.remove();
            for(int child : adj.get(node)){
                indegree[child]--;
                if(indegree[child]==0) queue.offer(child);
            }
        }
        return topo;
    }
    public boolean canFinish(int n, List<List<Integer>> adj) {
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