class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j,j,i);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                swap(matrix,i,j,i,n-j-1);
            }
        }
        
    }
    public void swap(int[][] arr,int i,int j, int m, int n){
        int temp = arr[i][j];
        arr[i][j]=arr[m][n];
        arr[m][n]=temp;
    }
}