class Solution {
    public int[] findOrder(int V, int[][] mat) {
        if(mat.length==0){
            int[] ans = new int[V];
            int j = V-1;
            for(int i=0;i<V;i++){
                ans[i] = j--;
            }
        }
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<mat.length;i++){
            int pre = mat[i][0];
            int course = mat[i][1];
            adj.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.offer(i);
        }
        int z = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            arr.add(z++,node);
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0) q.offer(i);
            }
        }
        if(arr.size()<V) return new int[]{};
        int[] ans = new int[arr.size()];
        int k = 0;
        Collections.reverse(arr);
        for(int i:arr){
            ans[k++] = i;
        }
        return ans;
    }
}