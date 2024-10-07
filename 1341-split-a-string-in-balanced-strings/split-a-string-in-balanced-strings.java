class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int ans = 0;
        for(char i : s.toCharArray()){
            if(i=='R') count++;
            else count--;
            if(count==0) ans++;
        }
        return ans;
    }
}