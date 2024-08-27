class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max = 0;
        for(int num : map.keySet()){
            int currCount = map.get(num);
            int nextCount = map.getOrDefault(num+1,0);
            if(nextCount!=0){
                max = Math.max(max , currCount + nextCount);
            }
        }
        return max;
    }
}