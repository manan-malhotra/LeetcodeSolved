


public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1];
            if(i%2==1) ans[i]++;
        }
        return ans;
    }
}