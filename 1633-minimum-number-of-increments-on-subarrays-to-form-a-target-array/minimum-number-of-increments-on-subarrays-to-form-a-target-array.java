class Solution {
    public int minNumberOperations(int[] A) {
        int res = A[0];
        for (int i = 1; i < A.length; i++)
            if(A[i]>A[i-1]) res+=A[i]-A[i-1];
        return res;
    }
}