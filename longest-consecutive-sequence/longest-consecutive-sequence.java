class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int ans = 0;
        for(int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            System.out.println(right+"right");
            System.out.println(left+"left");
            System.out.println(set.size()+"size");
            ans = Math.max(ans,right - left - 1);
            if(set.isEmpty()) return ans;//save time if there are items in nums, but no item in hashset.
        }
        return ans;
    }
}