class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        int doubleDiff = diff*2;
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums){
            if(hs.contains(num-diff) && hs.contains(num-doubleDiff)) count++;
            hs.add(num);
        }
        return count;
    }
}