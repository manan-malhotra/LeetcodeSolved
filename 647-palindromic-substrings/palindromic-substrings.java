class Solution {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        return findPalindromes(arr, 0);
    }
    private int findPalindromes(char[] arr, int i) {
        int left = i;
        int right = i;
        int count = 0;
        if (i > arr.length - 1)  return 0;
        while(right < arr.length - 1 && arr[right] == arr[right + 1]) {
            right++;
        }
        for (int diff =  right - i + 1; diff > 0; diff--) {
            count += diff;
        }
        i = right;
        while (left > 0 && right < arr.length - 1 && arr[right + 1] == arr[left - 1]){
            count++;
            left--;
            right++;
        }
        return count += findPalindromes(arr, i + 1);
    }
}