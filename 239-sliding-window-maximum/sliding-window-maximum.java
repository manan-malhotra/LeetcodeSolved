class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        int n = nums.length;
        int[] dq = new int[n];
        int[] ans = new int[n-k+1];
        int start=-1;
        int end=-1;
        int i = 0;
        int j = 0;
        while(j!=n){
            if(end==-1){
                start++;
                end++;
                dq[end]=j;
            }else if(nums[j]<=nums[dq[end]]){
                end++;
                dq[end]=j;
            }else{
                while(end!=-1 && end>=start && nums[dq[end]]<nums[j]){
                    end--;
                }
                end++;
                dq[end]=j;
            }
            if(j-i+1==k){
                ans[i] = nums[dq[start]];
                if(dq[start]==i) start++;
                i++;
            }
            j++;
        }
        return ans;
    }
}