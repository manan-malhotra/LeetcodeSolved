class Solution {
    public int splitArray(int[] arr, int k) {
        int start = Integer.MIN_VALUE;
        int end = 0;

        for(int i : arr){
            if(i>start) start = i;
            end +=i;
        }

        while(start<end){
            int mid = start + (end-start)/2;
            int splits = 1;
            int currSum = 0;
            for (int i : arr) {
                if(currSum+i > mid){
                    currSum = i;
                    splits++;
                }else{
                    currSum+=i;
                }
            }
            if(splits>k){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return end;
    }
}