class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] roadCount = new int[n];
        int tempx=x, tempy=y;
        x=Math.min(tempx,tempy);
        y=Math.max(tempx,tempy);
        for(int i=1;i<=n;i++) {
            int currRoadCount=0;
            for(int j=i+1;j<=n;j++) {
                if(j<x || i>y) {
                    currRoadCount=j-i;
                } else {
                    int d1= Math.abs(x-i) + Math.abs(y-j)+1;
                    int d2= j-i;
                     currRoadCount = Math.min(d1,d2);
                }
                roadCount[currRoadCount-1]+=2;
                
            }

        }
        return roadCount;
    }
}