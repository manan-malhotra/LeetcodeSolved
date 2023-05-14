public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // If both string are not of the same length

        int[] store = new int[26]; // Create a bucket of 26 char; a=0, z=25; Only works if strings are just small letters and no numbers

        for (int i = 0; i < s.length(); i++) { // Iterate through the strings;
            store[s.charAt(i) - 'a']++; // Add 1 at ASCII value from s in the bucket store
            store[t.charAt(i) - 'a']--; // Sub 1 at ASCII value from t in the bucket store
        }

        for (int n : store) if (n != 0) return false; // If value of any char is not equal to 0, it is not a valid anagram

        return true; // else return true;
    }
}