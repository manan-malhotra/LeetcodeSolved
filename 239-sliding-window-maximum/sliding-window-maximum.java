class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        int n = nums.length;
        int[] dq = new int[n];
        int[] ans = new int[n-k+1];
        int start=-1;
        int end=-1;
        for(int i=n-1;i>=0;i--){
            if(end==-1){ // dq is empty
                start++;
                dq[++end]=i;
            }else if(nums[i]<=nums[dq[end]]){ // nums[i] is smaller
                dq[++end]=i;
                
            }else{
                while(end>=0 && nums[i]>nums[dq[end]] && end>=start){
                    end--;
                }
                end++;
                dq[end]=i;
            }
            if(start!=-1 && i==dq[start]-k){
                start++;
            }
            if(i<ans.length) ans[i]=nums[dq[start]];
            // ans[i]=dq[start];
        }
        return ans;
    }
}