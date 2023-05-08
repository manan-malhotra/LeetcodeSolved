class Solution {
    public int lengthOfLastWord(String a) {
        String[] arr = a.split(" ");
        int idx = arr.length-1;
        return (arr[idx].strip()).length();
    }
}