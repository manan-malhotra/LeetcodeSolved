class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max = 0;
        for(int num:nums){
            if(set.contains(num-1)) continue;
            int curr = num;
            int count = 0;
            while(set.contains(curr)){
                curr++;
                count++;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}