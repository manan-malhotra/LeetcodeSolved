class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();
        
        for(int n: nums)
            count.put(n, count.getOrDefault(n, 0)+1);

        for(int n: nums ) {

            if(count.get(n) == 0)
                continue;
            else if(tail.getOrDefault(n, 0) > 0) {
                tail.put(n, tail.get(n)-1);
                tail.put(n+1, tail.getOrDefault(n+1, 0)+1);
            }
            else if(count.getOrDefault(n+1, 0) > 0 && count.getOrDefault(n+2, 0) > 0) {
                count.put(n+1, count.get(n+1)-1);
                count.put(n+2, count.get(n+2)-1);
                tail.put(n+3, tail.getOrDefault(n+3 , 0)+1);
            }
            else
                return false;
            count.put(n, count.get(n)-1);
        }

        return true;
    }
}