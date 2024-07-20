class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        char[] ans = s.toCharArray(); 
        int left = 0; 
        int max = 0;         
        for (int right = 0; right < ans.length; right++) {
            arr[ans[right] - 'A']++;
            max = Math.max(max, arr[ans[right] - 'A']); 
            // Check if the current window is valid
            while ((right - left + 1) - max > k) {
                arr[ans[left++] - 'A']--; 
            }
        }
        
        return ans.length - left; 
    }
}