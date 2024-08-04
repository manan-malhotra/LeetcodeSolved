class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        var ans = new int[queries.length];
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n - 1; i++) {
            map.put(i, i + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            var u = queries[i][0];
            var v = queries[i][1];

            if (!map.containsKey(u)||map.get(u) >= v) {
                ans[i] = map.size();
                continue;
            }

            var j = map.get(u);
            while (j < v) {
                j = map.remove(j);
            }
            map.put(u, v);


            ans[i] = map.size();
        }
        
        return ans;
    }
}