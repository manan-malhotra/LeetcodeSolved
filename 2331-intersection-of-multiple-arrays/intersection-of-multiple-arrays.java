class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> hm = new TreeMap<>();
        for(int[] i : nums){
            for(int j:i){
                if(hm.containsKey(j)){
                    hm.put(j,hm.get(j)+1);
                }else{
                    hm.put(j,1);
                }
            }
        }
        for (Map.Entry<Integer,Integer> entry : hm.entrySet()) {
            if(entry.getValue()==n) ans.add(entry.getKey());
        }
        return ans;
    }
}