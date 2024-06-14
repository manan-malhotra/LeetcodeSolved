class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfsCheck(i,graph,visited,pathVisited);
            }
        }
        for(int i=0;i<n;i++){
            if(visited[i]==-1) ans.add(i);
        }
        return ans;
    }
    public boolean dfsCheck(int startNode, int[][] graph, int[] visited, int[] pathVisited) {
        visited[startNode] = 1;
        pathVisited[startNode] = 1;
        for(int childNode : graph[startNode]){
            if(visited[childNode]==0){
                if(dfsCheck(childNode,graph,visited,pathVisited)) return true;
            }
            if(pathVisited[childNode] == 1) return true;
        }
        pathVisited[startNode] = 0;
        visited[startNode] = -1;
        return false;
    }
}