class Solution {
      public int findKthPositive(int[] A, int k) {
        int l = 0, r = A.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] - 1 - m < k){
                l = m + 1;
                System.out.println("l"+l);
            }
            else
                r = m;
        }
        System.out.println("l"+l);
        return l + k;
    }
}
