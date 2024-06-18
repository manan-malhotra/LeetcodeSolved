class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        int minimumRequired = n-1;
        if(edges<minimumRequired) return -1;
        int newRequired = findSeperated(n,connections)-1;
        return newRequired;
    }
    public int findSeperated(int n, int[][] connections){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] arr:connections){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                count++;
                bfs(i,adj,visited);
            }
        }
        return count;
    }
    public void bfs(int start, List<List<Integer>> adj, int[] vis){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        vis[start]=1;
        while(!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> arr = adj.get(node);
            for(int j=0;j<arr.size();j++){
                    int curr = arr.get(j);
                    if(vis[curr]==0){
                    vis[curr]=1;
                    queue.offer(curr);
                }
            }
        }
    }
}