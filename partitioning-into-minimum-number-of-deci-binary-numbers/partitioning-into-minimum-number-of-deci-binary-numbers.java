class Solution {
    public int minPartitions(String n) {
        int len = n.length();
        int max = 0;
        for(int i=0;i<len;i++){
            int check = n.charAt(i) - '0';
            max = Math.max(max,check);
        }
        return max;
    }
}