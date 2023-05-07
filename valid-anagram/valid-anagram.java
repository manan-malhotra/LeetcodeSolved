public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // If both string are not of the same length
        HashMap<Character, Integer> map = new HashMap<>(); // Create a new hashmap
        for(int i=0;i<s.length();i++){ // Iterate through s string
            char ch = s.charAt(i); // get value of ith index of string s
            map.put(ch,map.getOrDefault(ch,0)+1); // if val already exists it will return that or else it will return 0
            // Add 1 to that value and put it again in the map
        }
        for(int i=0;i<t.length();i++){ // Iterate through t string
            char ch = t.charAt(i); // get value of ith index of string t
            if(map.get(ch)!=null){ // if the value at i exists
                if(map.get(ch)==1){
                    map.remove(ch); // if value to key is 1, remove it from the map
                }else{
                    map.put(ch,map.get(ch)-1); // else get the value and decrement
                }
            }else{ // else it is not an anagram
                return false;
            }
        }
        return map.isEmpty(); // if map is empty then return true
    }
}