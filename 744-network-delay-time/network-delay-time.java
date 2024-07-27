class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int vis[] = new int[n];
        Arrays.fill(vis,Integer.MAX_VALUE);
        vis[k-1] = 0;
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            int from = time[0]-1;
            int to = time[1]-1;
            int wt = time[2];
            adj.get(from).add(new Node(to,wt));
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(k-1,0));
        while(!q.isEmpty()){
            Node node = q.poll();
            int stop = node.stop;
            int wt = node.wt;
            for(Node newNode : adj.get(stop)){
                int newStop = newNode.stop;
                int newWt = wt + newNode.wt;
                if(vis[newStop]>newWt){
                    vis[newStop] = newWt;
                    q.offer(new Node(newStop,vis[newStop]));
                }
            }
        }
        int max = 0;
        for(int i : vis){
            max = Math.max(i,max);
        }
        return max==Integer.MAX_VALUE ? -1 : max;
    }
}
class Node{
    int stop;
    int wt;
    public Node(int stop, int wt){
        this.stop = stop;
        this.wt = wt;
    }
}