

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int ans = 0;
        for(int x : map.keySet()){
            if(k > 0 && map.containsKey(x + k) || k == 0 && map.get(x) > 1) ans++;
        }
        
        
        return ans;
    }
}
