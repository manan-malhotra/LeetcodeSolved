class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i: piles){
            if(i>max){
                max=i;
            }
        }
        while(min<max){
            int mid = min + (max-min)/2;
            int hoursReq = 0;
            for(int i:piles){
                hoursReq += (i/mid);
                if(i%mid!=0) hoursReq++;
            }
            //System.out.println(mid+" "+hoursReq);
            if(hoursReq <= h) max=mid;
            else min = mid+1;
        }
        return min;
    }
}