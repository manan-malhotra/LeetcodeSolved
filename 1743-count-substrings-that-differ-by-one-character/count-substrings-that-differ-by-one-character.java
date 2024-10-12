// version 4:  O(1)- space
class Solution {
    private String s;
    private String t;
    private int res = 0;
    public int countSubstrings(String s, String t) {
        this.s = s;
        this.t = t;
        
        // starting from left boundary dp[0][0], dp[1][0], ..., dp[m-1][0]
        for (int i = 0; i < s.length(); i++) {
            traverseRightBottom(i, 0);
        }
        
        // starting from top boundary dp[0][1], dp[0][2], ..., dp[0][n-1]
        for (int j = 1; j < t.length(); j++) {
            traverseRightBottom(0, j);
        }
        
        return res;
    }
    
    private void traverseRightBottom(int i, int j) {
        int prev0 = 0;      // dp[i][j][0]
        int prev1 = 0;      // dp[i][j][1]
        
        while (i < s.length() && j < t.length()) {
            boolean match = (s.charAt(i++) == t.charAt(j++));
            int curr0 = match ? prev0 + 1 : 0;            // dp[i+1][j+1][0]
            int curr1 = match ? prev1     : prev0 + 1;    // dp[i+1][j+1][1]
            
            res += curr1; 
            
            prev0 = curr0;
            prev1 = curr1;
        }
    }
}