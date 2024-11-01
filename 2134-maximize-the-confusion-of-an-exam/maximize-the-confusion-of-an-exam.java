class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max_consec_len = 0;
        int n = answerKey.length();
        int l = 0;
        int r = 0;
        int fcount = 0;
        int tcount = 0;
        int m = Math.min(fcount, tcount);
        while(r < n){
            while(r < n && m <= k){
                char c = answerKey.charAt(r);
                if(c == 'F'){
                    fcount++;
                }
                else{
                    tcount++;
                }
                m = Math.min(fcount, tcount);
                if(m > k){
                    r++;
                    break;
                }
                int len = r - l + 1;
                max_consec_len = Math.max(max_consec_len, len);
                r++;
            }
            while(l < r && m > k){
                char c = answerKey.charAt(l);
                if(c == 'F'){
                    fcount--;
                }
                else{
                    tcount--;
                }
                m = Math.min(fcount, tcount);
                l++;
            }
        }
        return max_consec_len;
    }
}