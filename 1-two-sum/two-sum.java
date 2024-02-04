class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int diff = target - num;
            if(hm.containsKey(diff)){
                return new int[] {hm.get(diff),i};
            }
            hm.put(num,i);
        }
        return new int[]{};
    }
}