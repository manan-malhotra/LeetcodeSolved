class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = matrix[i][j];
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j]==1){
                    int left = dp[i-1][j];
                    int up = dp[i][j-1];
                    int diagonal = dp[i-1][j-1];
                    int curr = dp[i][j];
                    if(left>=curr && diagonal>=curr && up>=curr){
                        dp[i][j]+=Math.min(up,Math.min(left,diagonal));
                    }
                }
            }
        }
        int total = 0;
        for(int[] row:dp){
            for(int num:row){
                System.out.print(num+" ");
                total+=num;
            }
            System.out.println();
        }
        return total;
    }
}