class Solution {
    public void setZeroes(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        boolean isFirstColumnZero = false;


        for(int i=0; i<nRows; i++) {
            if(matrix[i][0] == 0)
                isFirstColumnZero = true;

            for(int j=1; j<nCols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<nRows;i++) {
            for(int j=1;j<nCols;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(matrix[0][0] == 0) {
            for(int i=0;i<nCols;i++)
                matrix[0][i] = 0;
        }

        if(isFirstColumnZero) {
            for(int i=0;i<nRows;i++)
                matrix[i][0] = 0;
        }
    }
}