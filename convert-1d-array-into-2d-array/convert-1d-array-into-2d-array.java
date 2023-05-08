class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans = new int[m][];
        int k=0;
        int start = 0;
        if(m * n != original.length) {
            int[][] temp = new int[0][];
            return temp;
        }
        for(int i=1; i <= m; i++) {
            int[] temp = new int[n];
            int counter = 0;
            for(int j=start; j <= (i * n) - 1; j++) { 
                temp[counter] = original[j];
                counter++;
            }
            start = i * n;
            ans[k] = temp;
            k++;
        }

        return ans;
    }
}