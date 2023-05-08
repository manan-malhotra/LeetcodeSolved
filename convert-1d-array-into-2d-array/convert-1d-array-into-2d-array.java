class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if((m*n)!=original.length){
        System.out.println(original.length);
            return new int[][]{};
        }
        int[][] arr = new int[m][n];
        int i=0;
        int j=0;
        for(int num: original){
            arr[i][j++]=num;
            if(j==n){
                i++;
                j=0;
            }
        }
        return arr;
    }
}