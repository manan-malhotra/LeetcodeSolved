class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 0, count = 0, n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j!=n){
            int num = fruits[j++];
            map.put(num,map.getOrDefault(num,0)+1);
            while(map.size()>2){
                int oldNum = fruits[i++];
                map.put(oldNum, map.get(oldNum)-1);
                if(map.get(oldNum)==0) map.remove(oldNum);
            }
            count = Math.max(count,j-i);
        }
        return count;
    }
}