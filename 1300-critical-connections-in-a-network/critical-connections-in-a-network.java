class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        res = new ArrayList<>();

        List<Integer>[] adj = buildGraph(n, connections);
        int[] order = new int[n];
        dfs(0, -1, 1, adj, order);

        return res;
    }

    // Return the node with the smallest order this branch can find
    private int dfs(int curr, int prev, int rank, List<Integer>[] adj, int[] order) {
        if (order[curr] > 0) {
            return curr;
        }

        order[curr] = rank;

        int min = curr;
        for (int next : adj[curr]) {
            // Prevent from going back to previous node
            if (next == prev) {
                continue;
            }
            // The node with the smallest order this branch can find
            int smallest = dfs(next, curr, rank + 1, adj, order);
            if (order[smallest] == rank + 1) {
                res.add(Arrays.asList(curr, next));
            } else if (order[smallest] < order[min]) {
                min = smallest;
            }
        }

        return min;
    }

    // Build the adjacency list
    private List<Integer>[] buildGraph(int n, List<List<Integer>> connections) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            adj[edge.get(0)].add(edge.get(1));
            adj[edge.get(1)].add(edge.get(0));
        }

        return adj;
    }
}