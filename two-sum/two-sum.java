class Solution {

    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) { // If map already has the diff return index of diff and i
                return new int[] { prevMap.get(diff), i };
            }

            prevMap.put(num, i); // Else add it in the hashmap
        }

        return new int[] {};
    }
}
