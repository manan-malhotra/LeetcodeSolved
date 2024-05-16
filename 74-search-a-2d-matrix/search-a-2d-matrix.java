class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length;
        while(start<end){
            int mid = start + (end-start)/2;
            int n = matrix[mid].length;
            if(matrix[mid][0]>target){
                end = mid-1;
            }else if(matrix[mid][n-1]<target){
                start=mid+1;
            }else{
                start=mid;
                end=mid;
            }
        }
        if(start>matrix.length-1) return false;
        return binarySearch( matrix, start,target);
    }
    public boolean binarySearch(int[][] num,int k , int target){
        int start = 0;
        int end = num[k].length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(num[k][mid]==target){
                return true;
            }
            if(num[k][mid]>target){
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}