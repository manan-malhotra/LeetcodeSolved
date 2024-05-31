class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mp1 = new HashMap<>();
        int count = t.length();
        for (char i : t.toCharArray()) {
            mp1.put(i, mp1.getOrDefault(i, 0) + 1);
        }
        int i = 0, j = 0, mini = s.length() + 1, start = 0;
        while (j < s.length()) {
            if (mp1.containsKey(s.charAt(j)) && mp1.get(s.charAt(j)) > 0) {
                count--;
            }
            if (mp1.containsKey(s.charAt(j))) {
                mp1.put(s.charAt(j), mp1.get(s.charAt(j)) - 1);
            }
            while (count == 0) {
                if (mini > j - i + 1) {
                    mini = j - i + 1;
                    start = i;
                }
                if (mp1.containsKey(s.charAt(i))) {
                    mp1.put(s.charAt(i), mp1.get(s.charAt(i)) + 1);
                    if (mp1.get(s.charAt(i)) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        if (mini == s.length() + 1) {
            return "";
        }
        return s.substring(start, start + mini);
    }
}