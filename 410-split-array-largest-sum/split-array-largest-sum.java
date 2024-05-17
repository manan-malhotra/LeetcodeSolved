class Solution {
    public int splitArray(int[] nums, int k) {
        int sum  = 0;
        int max = nums[0];
        for(int i:nums){
            if(i>max) max = i;
            sum+=i;
        }
        int start = max;
        int end = sum;
        while(start<end){
            int mid = start + (end-start)/2;
            int t = findSubArrays(nums,mid);
            if(t>k){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
    public int findSubArrays(int[] nums,int mid){
        int temp = mid;
        int t = 1;
        for(int i:nums){
            if(i>temp){
                t++;
                temp=mid;
            }
                temp-=i;
        }
        return t;
    }
}