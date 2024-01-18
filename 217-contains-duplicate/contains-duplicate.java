class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i)){
                return true;
            }else{
                hm.put(i,1);
            }
        }
        return false;
    }
}