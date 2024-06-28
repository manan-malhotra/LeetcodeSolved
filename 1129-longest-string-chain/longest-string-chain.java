class Solution {
    public int longestStrChain(String[] words) {
        int ans = 1;
        int n = words.length;
        int[] dp = new int[n];
        dp[0] = 1;
        Arrays.sort(words,(a, b)-> a.length() - b.length());
        for(int i=1;i<n;i++){
            int maxVal = 0;
            for(int j=0;j<i;j++){
                if(compareStrings(words[i],words[j])) maxVal = Math.max(maxVal,dp[j]);
                dp[i] = maxVal+1;
                ans = Math.max(dp[i],ans);
            }
        }
        return ans;
    }
    public boolean compareStrings(String bigger, String smaller){
        int l1 = bigger.length();
        int l2 = smaller.length();
        if(l1-l2!=1) return false;
        int i=0,j=0;
        while(i!=l1 && j!=l2 && i-j<2){
            if(bigger.charAt(i)==smaller.charAt(j)){
                i++;
                j++;
            }else i++;
        }
        return (j==l2 && (i==l1 || i==l1-1));
    }
}