class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int n = firstList.length;
        int m = secondList.length;
        int i =0;
        int j = 0;
        while(i!=n && j!=m){
            if(firstList[i][1]<secondList[j][0]) i++;
            else if(secondList[j][1]<firstList[i][0]) j++;
            else{
                int[] temp = new int[2];
                temp[0] = Math.max(firstList[i][0],secondList[j][0]);
                temp[1] = Math.min(firstList[i][1],secondList[j][1]);
                ans.add(temp);
                if(firstList[i][1]<secondList[j][1]) i++;
                else j++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}