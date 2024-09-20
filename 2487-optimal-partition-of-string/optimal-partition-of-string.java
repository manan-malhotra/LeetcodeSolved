class Solution {
    public int partitionString(String s) {
        int map[] = new int[26];
        int count = 1;
        for(char ch : s.toCharArray()){
            if(map[ch-'a']++==1){
                map = new int[26];
                map[ch-'a']++;
                count++;
            }
        }
        return count;
    }
}