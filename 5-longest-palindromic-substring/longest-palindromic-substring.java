class Solution {
    public int start = 0;
    public int end = 0;

    private void palindrome(char[] ch, int i) {
        int l = i;
        int r = i;
        int n = ch.length;
        if (i >= n - 1)
            return;
        while (r < n - 1 && ch[r] == ch[r + 1]) {
            r++;
        }
        i = r;
        while (l > 0 && r < n - 1 && ch[l - 1] == ch[r + 1]) {
            l--;
            r++;
        }
        if ((end - start) < (r - l)) {
            end = r;
            start = l;
        }
        palindrome(ch, i + 1);
    }

    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        palindrome(ch, 0);
        return s.substring(start, end + 1);
    }
}