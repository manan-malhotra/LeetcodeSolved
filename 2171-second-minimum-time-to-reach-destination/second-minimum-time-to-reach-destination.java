class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
		// build the graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new HashSet<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
		// keep two min times for each node
        int[][] visited = new int[n+1][2]; //{min, secMin}
        for (int[] v : visited) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{1, 0}); // {curNode, curTime}
        
        int min = Integer.MAX_VALUE, secMin = min;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0], curTime = cur[1];

			// update the global value when reach target
            if (curNode == n) {
                if (curTime < min) {
                    secMin = min;
                    min = curTime;
                } else if (curTime != min && curTime < secMin) {
                    secMin = curTime;
                }
            }
            
			// calculate if we need to wait for the green light, if change is 5, then:
			// 0~4 green
			// 5~9 red
			// 10 ~14 green
			// ...
            if ((curTime / change) % 2 ==1) {
                curTime += change - (curTime % change);
            }
            
            int nextTime = curTime + time;
            
            for (int nxt : graph.get(curNode)) {
                int nxtMin = visited[nxt][0], nxtSecMin = visited[nxt][1];
                if (nextTime < nxtMin) { // update min
                    visited[nxt][1] = nxtMin;
                    visited[nxt][0] = nextTime;
                    pq.offer(new int[]{nxt, nextTime});
                } else if (nextTime != nxtMin && nextTime < nxtSecMin) { // update secMin
                    visited[nxt][1] = nextTime;
                    pq.offer(new int[]{nxt, nextTime});
                }
            }
        }
  
        return secMin;
    }
}