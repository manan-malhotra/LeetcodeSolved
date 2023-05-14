class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> temp = new HashSet<>();
        int count=0;
        for(int num: nums)
        {
            count++;
            temp.add(num);

            if(temp.size()!=count)
               return true;
        }
            return false;
    }
}