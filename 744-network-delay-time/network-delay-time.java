class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u-1).add(new Pair(w,v-1));
        }
        return dijkstra(n,adj,k-1);
    }
    public int dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance);
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        pq.add(new Pair(0,src));
        while(pq.size()!=0){
            Pair pair = pq.poll();
            int node = pair.node;
            int distance = pair.distance;
            ArrayList<Pair> edges = adj.get(node);
            for(Pair edge:edges){
                int edgeW = edge.distance;
                int adjN = edge.node;
                if(edgeW + distance < dist[adjN]){
                    dist[adjN] = edgeW + distance;
                    pq.add(new Pair(dist[adjN],adjN));
                }
            }
        }
        int max = -1;
        for(int i : dist){
            if(i==1e9) return -1;
            if(i>max) max=i;
        }
        return max;
    }
}
class Pair{
    int distance;
    int node;
    public Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}