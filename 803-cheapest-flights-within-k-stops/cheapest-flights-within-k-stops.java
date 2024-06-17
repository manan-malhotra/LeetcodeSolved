class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Stop>> adj = new ArrayList<>();
        int[] visited = new int[n];
        Arrays.fill(visited,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Stop>());
        }
        for(int[] flight:flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.get(from).add(new Stop(to,price));
        }
        int ans = Integer.MAX_VALUE;
        Queue<Stop> queue = new LinkedList<>();
        queue.offer(new Stop(src,0));
        k+=2;
        while(k!=0 && !queue.isEmpty()){
            k--;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Stop currentStop = queue.poll();
                int stop = currentStop.stop;
                int price = currentStop.price;
                if(stop==dst) ans = Math.min(price,ans);
                for(Stop stops : adj.get(stop)){
                    int newStop = stops.stop;
                    int newprice = stops.price+price;
                    if(visited[newStop]>newprice){
                        queue.offer(new Stop(newStop,newprice));
                        visited[newStop] = newprice;
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
class Stop{
    int stop;
    int price;
    public Stop(int stop,int price){
        this.stop=stop;
        this.price=price;
    }
}