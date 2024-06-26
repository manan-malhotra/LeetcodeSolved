class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for(int num: nums)
        {
            if(hm.contains(num))
                return true;
            hm.add(num);
        }
            return false;
    }
}