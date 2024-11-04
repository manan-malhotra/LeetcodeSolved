class Solution {
    List<List<Integer>> ans;
    List<Integer> temp;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();    
        temp = new ArrayList<>();    
        temp.add(0);
        dfs(0,graph);
        return ans;
    }
    public void dfs(int i,int[][] graph){
        if(i==graph.length-1){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int child:graph[i]){
            temp.add(child);
            dfs(child,graph);
            temp.remove(temp.size()-1);
        }
    }
}