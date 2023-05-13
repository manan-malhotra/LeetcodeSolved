class Solution {
    public List<Integer> findDuplicates(int[] nums) {
 Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                ans.add(key);
            }
        }

        return ans;
    }
}