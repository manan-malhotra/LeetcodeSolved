// Unique

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = 0;
        int maxCount = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < n) {
            // Perform operation on right
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxCount = Math.max(maxCount, map.get(rightChar));

            // If the window size minus the count of the most frequent character is greater than k
            // Reduce the window from the left
            // maxCount is the maximum of same character, the condition dicdated we can change anything to the required character 
            //so the remaining characters == length-maxCount. Here "current_length" is right-left+1. hope it is clear now
            if (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                /* this part is not required because we dont have to do 
                anything with size() of map reference fruits into basket
                
                if(map.get(leftChar)==0) map.remove(leftChar);

                */
                
                left++;
            }

            // Compute the max length
            max = Math.max(max, right - left + 1);
            // Increment right to calculate for the next value
            right++;
        }
        return max;
    }
}