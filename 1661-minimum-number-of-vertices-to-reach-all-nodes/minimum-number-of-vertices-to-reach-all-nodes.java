class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(List<Integer> edge : edges){
            int to = edge.get(0);
            int from = edge.get(1);
            adj.get(from).add(to);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(adj.get(i).size()==0) ans.add(i);
        }
        if(ans.size()==0) ans.add(0);
        return ans;
    }
}