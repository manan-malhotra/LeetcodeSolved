class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder s = new StringBuilder("123456789".substring(0, pattern.length() + 1));
        int j = 0;

        for (int i = 0; i <= pattern.length(); i++) {
            if (i < pattern.length() && pattern.charAt(i) == 'D') {
                j++;
                continue;
            }

            if (j > 0) {
                StringBuilder ns = new StringBuilder(s.substring(i - j, i + 1));
                s.replace(i - j, i + 1, ns.reverse().toString());
                j = 0;
            }

        }

        return s.toString();
    }
}