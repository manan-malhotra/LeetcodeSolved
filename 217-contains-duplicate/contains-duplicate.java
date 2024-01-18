class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for(int i:nums){
            hm.add(i);
        }
        return hm.size()!=nums.length;
    }
}