class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] map = new int[n+1];
        for(int[] edge:edges){
            map[edge[0]-1]++;
            map[edge[1]-1]++;
        }
        for(int i=0;i<map.length;i++){
            if(map[i]==n) return i+1;
        }
        return 0;
    }
}