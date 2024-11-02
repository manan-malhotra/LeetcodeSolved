class Solution {
    int count =0;
    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i< m ; i++){
            for(int j =0; j< n; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
        }
        int res = recursion(mat, 0);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    private int recursion(int [][]mat, int ci){
        if(count ==0){
            return 0;
        }
        int m = mat.length;
        int n = mat[0].length;
        if(ci >= m*n){
            return Integer.MAX_VALUE;
        }
         int res = Integer.MAX_VALUE;
        int flip = Integer.MAX_VALUE;
        int nonflip = recursion(mat,ci+1);
        res = Math.min(res, nonflip);
        flipMatrix(mat, ci);
        int curr = recursion(mat, ci+1);
        if(curr != Integer.MAX_VALUE){
            flip = 1+ curr;
        }
        flipMatrix(mat, ci);
        res = Math.min(flip, res);
        return res;

    }

    private void flipMatrix(int[][]mat, int ci){
        int m = mat.length;
        int n = mat[0].length;
        int r = ci/n;
        int c = ci%n;

        if(mat[r][c] == 0){
            mat[r][c] = 1;
            count++;
        }else {
            mat[r][c] = 0;
            count--;
        }

        int [][]dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int []d : dirs){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr <0 || nr>= m || nc< 0 || nc>=n){
                continue;
            }
            if(mat[nr][nc] == 1){
                mat[nr][nc] = 0;
                count--;
            }else {
                mat[nr][nc] = 1;
                count++;
            }
        }
    }
}