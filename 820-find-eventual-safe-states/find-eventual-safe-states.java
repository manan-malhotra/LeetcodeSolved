class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> revadj = new ArrayList<>();
        int[] outdegree = new int[n];
        for(int i=0;i<n;i++){
            revadj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int num : graph[i]){
                revadj.get(num).add(i);
                outdegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdegree[i]==0)queue.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.peek());
            int node = queue.poll();
            for(int child:revadj.get(node)){
                if(--outdegree[child]==0){
                    queue.add(child);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}