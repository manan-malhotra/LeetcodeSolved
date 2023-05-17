class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isCol0 = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) isCol0=true;
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0|| matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }
        if(isCol0){
            for(int j=0;j<m;j++){
                matrix[j][0]=0;
            }
        }
    }
}