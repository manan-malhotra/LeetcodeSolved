class Solution {
    
    double val;
    
    public void dfs(Map<String, List<Pair<String, Double>>> adj, String src, String dst, double curVal, Set<String> visited) {
        if (src.equals(dst)) {
            val = curVal;
            return;
        }
        
        visited.add(src);
        
        for (Pair<String, Double> p : adj.get(src)){
            if (!visited.contains(p.getKey())) {
                dfs(adj, p.getKey(), dst, curVal*p.getValue(), visited); // mulitplying the value before going to the next index with the cur edge value
            }
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        int n = equations.size();
        
        Map<String, List<Pair<String, Double>>> adj = new HashMap<>();
        
        for (int i = 0 ; i < n ; i++) {
            List<String> eq = equations.get(i);
            String u = eq.get(0);
            String v = eq.get(1);
            double w = values[i];
            
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new Pair(v, w)); // putting record for u -> v along with the val;
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(v).add(new Pair(u, 1/w)); // putting record for v -> u along with the inverse val;
        }
        
        
        int m = queries.size();
        
        double[] ans = new double[m];
        
        for (int i = 0 ; i < m ; i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            
            // if adj doesn't contain u then there is no point of checking
            if (!adj.containsKey(u)) {
                ans[i] = -1;
                continue;
            }
            
            val = -1;
            
            dfs(adj, u, v, 1, new HashSet<>());
            ans[i] = val;
        }
        
        return ans;
        
    }
}