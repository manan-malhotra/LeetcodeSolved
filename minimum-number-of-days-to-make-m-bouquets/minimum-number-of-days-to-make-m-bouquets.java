class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m>bloomDay.length/k) return -1;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i:bloomDay){
            if(i>end) end = i;
            if(i<start) start=i;
        }
        while(start<end){
            int mid = start + (end-start)/2;
            int flowers = 0;
            int adj = 0;
            for(int i:bloomDay){
                
                if(i<=mid) adj++;
                else adj=0;
                if(adj==k){
                    flowers++;
                    adj=0;
                }
            }
            
            if(flowers>=m) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}