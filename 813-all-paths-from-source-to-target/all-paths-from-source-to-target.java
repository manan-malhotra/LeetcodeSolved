class Solution {
    List<List<Integer>> ans;
    List<Integer> temp;
    int[] pathVis;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();    
        temp = new ArrayList<>();    
        pathVis = new int[graph.length];
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
            if(pathVis[child]==0){
                temp.add(child);
                pathVis[child]=1;
                dfs(child,graph);
                pathVis[child]=0;
                temp.remove(temp.size()-1);
            }
        }
    }
}