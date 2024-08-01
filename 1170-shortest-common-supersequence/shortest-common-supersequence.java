class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        if(str1.equals(str2)) return str1;
        String lcs = longestCommonSubsequence(str1,str2);
        int l = lcs.length();
        if(l==0) return str1+str2;
        int n = str1.length();
        int m = str2.length();
        int i=0,j=0,k=0;
        StringBuilder ans = new StringBuilder();
        while(i!=n && j!=m && k!=l){
            char s1 = str1.charAt(i);
            char s2 = str2.charAt(j);
            char s3 = lcs.charAt(k);
            if(s1 == (s2)){
                ans.append(s1);
                i++;
                j++;
                k++;
            }else if(s1 == (s3)){
                ans.append(s2);
                j++;
            }else{
                ans.append(s1);
                i++;
            }
        }
        while(i!=n){
            ans.append(str1.charAt(i++));
        }
        while(j!=m){
            ans.append(str2.charAt(j++));
        }
        return ans.toString();
    }
    public String longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                    int right = dp[i][j+1];
                    int down = down = dp[i+1][j];
                    dp[i][j] = Math.max(right,down);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        while(i!=n && j!=m){
            int right = dp[i+1][j];
            int down = dp[i][j+1];
            int diagonal = dp[i+1][j+1];
            int curr = dp[i][j];
            if(right==down && curr-1==diagonal ){
                sb.append(text1.charAt(i));
                i++;
                j++;
            }else if(down<right){
                i++;
            }else{
                j++;
            }
        }
        String lcs = sb.toString();
        return lcs;
    }
}


