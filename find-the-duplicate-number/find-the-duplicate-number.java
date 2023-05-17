class Solution {
    public int findDuplicate(int[] nums) {
       int n = nums.length;
        boolean radix[] = new boolean[n];
        for (int num: nums) {
            if(radix[num])
                return num;
            radix[num] = true;
        }
        return -1;
    }
}