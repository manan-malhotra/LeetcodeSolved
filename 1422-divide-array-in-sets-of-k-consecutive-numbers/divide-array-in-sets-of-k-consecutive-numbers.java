class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n%k!=0) return false;
        System.out.println(n+" "+k);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(map.containsKey(num-1)) continue;
            else if(map.containsKey(num)){
                for(int i=0;i<k;i++){
                    int newNum = num+i;
                    if(!map.containsKey(newNum)) return false;
                    map.put(newNum,map.get(newNum)-1);
                    if(map.get(newNum)==0){
                        map.remove(newNum);
                    }
                }
            }
        }
        for(int num:map.keySet()){
            System.out.println(num);
        }
        return map.size()==0;
    }
}