class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,((x,y)->x[1]-y[1]));
        int overlapping = 0;
        int[] currInterval = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start<currInterval[1]) overlapping++;
            else{
                currInterval[0] = start;
                currInterval[1] = end;
            }
        }
        return overlapping;
    }
}