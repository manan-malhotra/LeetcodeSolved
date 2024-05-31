class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int a = upto(nums,k);
        int b = upto(nums,k-1);
        return a-b;
    }
    public int upto(int[] nums, int k){
        if(k==0) return 0;
        int i = 0, j=0, n=nums.length;
        int ans = 0;
        int count =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j!=n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(map.get(nums[j])==1) count++;
            if(count>k){
                while(count>k){
                    map.put(nums[i],map.get(nums[i])-1);
                    if(map.get(nums[i])==0) count--;
                    i++;
                }
            }
            j++;
            ans+=j-i;
        }
        return ans;
    }
}