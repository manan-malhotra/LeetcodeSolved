class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] newArr = new int[2];
        newArr = intervals[0];
        result.add(newArr);
        for(int[] interval : intervals){
            if(interval[0]<=newArr[1]){
                newArr[1]=Math.max(newArr[1],interval[1]);
            }else{
                newArr = interval;
                result.add(newArr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}