class Solution {
    static int MaxCon;
    static int dots;
    public void dfs(int start, HashSet<Integer>[] grapf, HashSet<Integer> visited)
    {
        visited.remove(start);
        for(int neib : grapf[start])
        {
            MaxCon++;
            if (visited.contains(neib))
                dfs(neib, grapf, visited);
        }
        dots++;
    }
    public void fullGraph(HashSet<Integer>[] grapf, int[][] connections)
    {
        for(int[] con : connections)
        {
            grapf[con[0]].add(con[1]);
            grapf[con[1]].add(con[0]);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        MaxCon = 0;
        dots = 0;
        HashSet<Integer>[] grapf = new HashSet[n];
        for(int i = 0; i < n; i++)
            grapf[i] = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++) visited.add(i);
        fullGraph(grapf, connections);
        int countCol = -1;
        int use = 0;
        for(int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                MaxCon = 0;
                dots = 0;
                countCol++;
                dfs(i, grapf, visited);
                use += MaxCon/2 -dots + 1;
            }

        }
        if(use >= countCol)
            return countCol;
        return -1;
    }
}