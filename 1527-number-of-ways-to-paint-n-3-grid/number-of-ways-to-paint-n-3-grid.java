class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;
        long dpPreviousRed = 6;
        long dpPreviousBlue = 6;

        for (int i = 2; i <= n; i++) {
            long newDpRed = (2 * dpPreviousRed + 2 * dpPreviousBlue) % MOD;
            long newDpBlue = (2 * dpPreviousRed + 3 * dpPreviousBlue) % MOD;
            
            dpPreviousRed = newDpRed;
            dpPreviousBlue = newDpBlue;
        }

        return (int)((dpPreviousRed + dpPreviousBlue) % MOD);
    }
}