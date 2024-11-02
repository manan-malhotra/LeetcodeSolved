class Solution {
    public int minNumberOperations(int[] A) {
        int res = A[0];
        for (int i = 1; i < A.length; ++i)
            res += Math.max(A[i] - A[i - 1], 0);
        return res;
    }
}