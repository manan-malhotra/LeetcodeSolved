// Unique

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = 0;
        int maxCount = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < n) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxCount = Math.max(maxCount, map.get(rightChar));

            if (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if(map.get(leftChar)==0) map.remove(leftChar);

                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}