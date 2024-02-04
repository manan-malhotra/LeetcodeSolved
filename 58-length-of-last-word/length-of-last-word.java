class Solution {
    public int lengthOfLastWord(String s) {
        String[] ans = s.split(" ");
        return ans[ans.length-1].length();
    }
}