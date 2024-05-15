class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int ans = 0;
        for(int i:nums){
            hashSet.add(i);
        }
        for(int i:nums){
            if(!hashSet.contains(i-1)){
                int currentStreak = 1;
                int currentNum = i;
                hashSet.remove(i);
                while(hashSet.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                    hashSet.remove(currentNum);
                }
                ans = Math.max(ans,currentStreak);
            }
        }
        return ans;
    }
}