class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return uptoK(nums,k) - uptoK(nums,k-1);
    }
    public int uptoK(int[] nums, int k){
        if(k==0) return 0;
        int n = nums.length;
        int i = 0;
        int j=0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(i!=n){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j])==0){
                    map.remove(nums[j]);
                }
                j++;
            }
            count += i-j+1;
            i++;
        }
        return count;
    }
}