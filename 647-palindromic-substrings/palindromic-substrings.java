class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        f(s,0,n-1,dp);
        int sum = 0;
        for(int[] row : dp){
            for(int num:row){
                if(num==1) sum++;
            }
        }
        return sum;
    }
    public int f(String s, int start, int end,int[][] dp){
        if(start>end) return 0;
        if(dp[start][end]!=-1) return dp[start][end];
        dp[start][end] = isPalindrome(s,start,end);
        return f(s,start+1,end,dp) + f(s,start, end-1,dp);
    }
    public int isPalindrome(String s, int start, int end){
        if(start>end) return 0;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return 0;
            start++;
            end--;
        }
        return 1;
    }
}