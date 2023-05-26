class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            boolean isOverlapping = true;
            while(isOverlapping){
                if(i<intervals.length-1 && end>=intervals[i+1][0]){
                    i++;
                    start = Math.min(start,intervals[i][0]);
                    end = Math.max(end,intervals[i][1]);
                }else{
                       isOverlapping=false; 
                }
            }
            List<Integer> arr = new ArrayList<>();
            arr.add(start);
            arr.add(end);
            ans.add(arr);
        }
        int[][] res = new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            res[j][0] = (int)ans.get(j).get(0);
            res[j][1] = (int)ans.get(j).get(1);
        }
        return res;
    }
}