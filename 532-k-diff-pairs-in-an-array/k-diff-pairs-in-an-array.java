

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> a = new HashMap<>();
        for (int i : nums) {
            a.put(i, a.getOrDefault(i, 0) + 1);
        }
        
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if (k == 0) {
                if (value > 1) {
                    ans++;
                }
            } else if (a.containsKey(key + k)) {
                ans++;
            }
        }
        
        return ans;
    }
}
