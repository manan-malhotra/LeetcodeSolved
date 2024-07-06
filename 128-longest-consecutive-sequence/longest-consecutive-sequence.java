class Solution {
    public int longestConsecutive(int[] nums) {
        int count = 0;
        int n = nums.length;
        if(n==0) return 0;
        HashSet<Integer> hashset = new HashSet<>();
        for(int num : nums) hashset.add(num);
        for(int num:nums){
            if(hashset.contains(num-1)) continue;
            int currentCount = 1;
            while(hashset.contains(num+1)){
                hashset.remove(num);
                currentCount++;
                num++;
            }
            count = Math.max(currentCount,count);
        }
        return count;
    }
}