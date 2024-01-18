class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for(int i:nums){
            if(hm.contains(i)){
                return true;
            }else{
                hm.add(i);
            }
        }
        return false;
    }
}