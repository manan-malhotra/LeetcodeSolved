import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (p.length() > s.length()) return result;

        // Create a hashmap to save the frequency of each character in the target substring p
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Maintain a counter to check how many characters match the target string
        int matchCounter = charCountMap.size();

        // Two pointers for the sliding window
        int left = 0, right = 0;

        // Loop over the string s with the right pointer
        while (right < s.length()) {
            char rightChar = s.charAt(right);

            // Decrease the frequency of the right character in the map
            if (charCountMap.containsKey(rightChar)) {
                charCountMap.put(rightChar, charCountMap.get(rightChar) - 1);
                if (charCountMap.get(rightChar) == 0) {
                    matchCounter--;
                }
            }
            right++;

            // Increase the left pointer to maintain the window's validity
            while (matchCounter == 0) {
                char leftChar = s.charAt(left);

                // When the window length matches p's length, it's a valid anagram
                if (right - left == p.length()) {
                    result.add(left);
                }

                // Move the left pointer to the right and adjust the map and counter
                if (charCountMap.containsKey(leftChar)) {
                    charCountMap.put(leftChar, charCountMap.get(leftChar) + 1);
                    if (charCountMap.get(leftChar) > 0) {
                        matchCounter++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}