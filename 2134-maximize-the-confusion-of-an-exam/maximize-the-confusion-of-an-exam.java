class Solution {
    public int solve(String answerKey, int k, char letter)
    {
        int left = 0;
        int right = 0;
        int c = 0;
        int ans = 0;
        while(right<answerKey.length())
        {
            if(answerKey.charAt(right)==letter)
            {
                c++;
            }
            if(c>k)
            {
                if(answerKey.charAt(left)==letter)
                {
                    c--;
                }
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(solve(answerKey,k,'T'),solve(answerKey,k,'F'));
    }
}