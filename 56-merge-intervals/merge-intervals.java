class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        int[] curr = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            if(curr[1]>=start){
                curr[1] = Math.max(curr[1],intervals[i][1]);
            }else{
                result.add(new int[]{curr[0],curr[1]});
                curr[0] = start;
                curr[1] = intervals[i][1];
            }
        }
        result.add(new int[]{curr[0],curr[1]});
        return result.toArray(new int[result.size()][2]);
    }
}