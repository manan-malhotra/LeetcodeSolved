class Solution {
    public int minPartitions(String n) {
      int max = 0;
       for(char c : n.toCharArray())
            if(max<(c-'0')) max=c-'0';
        return max;
    }
}