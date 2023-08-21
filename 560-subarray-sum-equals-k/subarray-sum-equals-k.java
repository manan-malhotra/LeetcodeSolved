class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        Map<Integer,Integer> hm = new HashMap();
        int preSum = 0, cnt = 0;
        hm.put(0, 1); 
        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            int remove = preSum - k;
            cnt += hm.getOrDefault(remove, 0);
            hm.put(preSum, hm.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}