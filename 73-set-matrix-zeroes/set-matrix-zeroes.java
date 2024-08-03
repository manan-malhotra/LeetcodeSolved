class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int[] row = new int[n];
        int m = matrix[0].length;
        int[] col = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int r : row) System.out.print(r+" ");
        System.out.println();
        for(int c : col) System.out.print(c+" ");
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}