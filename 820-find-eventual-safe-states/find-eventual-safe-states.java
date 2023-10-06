class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(graph,vis,pathVis,i,arr);
            }
        }
        Collections.sort(arr);
        return arr;
    }
    public boolean dfs(int[][] graph,int[] vis,int[] pathVis,int i, List<Integer> arr){
        int n = graph.length;
        if(vis[i]==1){
            if(pathVis[i]==1){
                //cycle
                return false;
            }else{
                return true;
                //dont go ahead
            }
        }
        vis[i]=1;
        pathVis[i]=1;
        for(int j:graph[i]){
            if(!dfs(graph,vis,pathVis,j,arr)) return false;
        }
        arr.add(i);
        pathVis[i]=0;
        return true;
    }
}