class Solution {
    int min = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] vis = new int[n];
        Arrays.fill(vis,Integer.MAX_VALUE);
        vis[src] = 0;
        List<List<Edge>> adj = new ArrayList<>();
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int to = flight[1];
            int from = flight[0];
            int weight = flight[2];
            adj.get(from).add(new Edge(to,weight));
        }
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(src,0));
        k+=2;
        while(!queue.isEmpty() && k!=0){
            k--;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Edge oldEdge = queue.poll();
                int to = oldEdge.to;
                int wt = oldEdge.weight;
                if(to==dst) min = Math.min(min,wt);
                for(Edge edge : adj.get(to)){
                    int newStop = edge.to;
                    int newWt = edge.weight + wt;
                    if(vis[newStop]>newWt){
                        queue.offer(new Edge(newStop,newWt));
                        vis[newStop] = newWt;
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


}
class Edge{
    int to;
    int weight;
    public Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}