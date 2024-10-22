class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        dp = new Boolean[n+1][m];
        return isMatch(0,s,0,p,n,m);
    }
    private boolean isMatch(int i, String s, int j, String p,int n, int m) { 
        if(j==m) { // since * in p can match 0 of previous char, so empty string(i==n) may match p
            return i==n;    
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(j+1<m && p.charAt(j+1)=='*') { //match *, needs to look at the next char to repeate current char
            if(isMatch(i,s,j+2,p,n,m)) {
                return dp[i][j] = true;
            }
            while(i<n && (p.charAt(j) == '.'||p.charAt(j)==s.charAt(i))) {
                if(isMatch(++i,s,j+2,p,n,m)) {
                    return dp[i][j] = true;
                }
            }
        } else if(i<n && (s.charAt(i) == p.charAt(j) ||    //match char
                   p.charAt(j)=='.')) {              //match dot
            return dp[i][j] = isMatch(i+1, s, j+1, p,n,m);
        }
        return dp[i][j] = false;
    }
}